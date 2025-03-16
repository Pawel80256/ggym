import React, { createContext, useContext, useEffect, useState } from "react";
import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
    url: "http://localhost:8081/",
    realm: "ggym",
    clientId: "ggym-ui",
});

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

    useEffect(() => {
        keycloak.init({ onLoad: "login-required", checkLoginIframe: false })
            .then(authenticated => {
                setAuthenticated(authenticated);
                setToken(authenticated ? keycloak.token : undefined);
                setLoading(false);

                if (authenticated) {
                    setInterval(() => {
                        keycloak.updateToken(30).then(refreshed => {
                            if (refreshed) {
                                setToken(keycloak.token);
                            }
                        }).catch(() => {
                            console.error("Error while refreshing token");
                        });
                    }, 30000); //30s
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