import './App.css'
import {useAuth} from "./AuthContext.tsx";

function App() {
    const {keycloak, logout} = useAuth()
    return (
        <div>
            <h1>Witaj, {keycloak.tokenParsed?.preferred_username}</h1>
            <p>Twoje role: {(keycloak.tokenParsed?.realm_access?.roles || []).join(", ")}</p>
            <button onClick={logout}>Wyloguj się</button>
        </div>
    )
}

export default App
