import Keycloak from "keycloak-js";

export const keycloak = new Keycloak({
    url: "http://localhost:8081/",
    realm: "ggym",
    clientId: "ggym-ui",
});