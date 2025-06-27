import React, {createContext, useContext, useEffect, useRef, useState} from "react";
import Keycloak from "keycloak-js";
import {keycloak} from "./keycloak.ts";

interface AuthContextType {
    keycloak: Keycloak;
    authenticated: boolean;
    loading: boolean;
    token?: string;
    logout: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
    const [authenticated, setAuthenticated] = useState(false);
    const [loading, setLoading] = useState(true);
    const [token, setToken] = useState<string | undefined>(undefined);
    const didInit = useRef(false);

    useEffect(() => {
        if (didInit.current) return;
        didInit.current = true;

        keycloak.init({ onLoad: "login-required", checkLoginIframe: false, redirectUri: window.location.origin })
            .then(auth => {
                setAuthenticated(auth);
                setToken(auth ? keycloak.token : undefined);
                setLoading(false);

                if (auth) {
                    const interval = setInterval(() => {
                        keycloak.updateToken(30).then((refreshed) => {
                            if (refreshed) {
                                setToken(keycloak.token);
                            }
                        });
                    }, 30_000);
                    return () => clearInterval(interval);
                }
            })
            .catch(() => setLoading(false));
    }, []);

    return (
        <AuthContext.Provider value={{ keycloak, authenticated, loading, token, logout: () => keycloak.logout() }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error("useAuth must be used within an AuthProvider");
    }
    return context;
};