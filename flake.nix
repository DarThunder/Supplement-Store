
{
  description = "Entorno de desarrollo - Sistema de inventario Spring Boot + MySQL";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          inherit system;
        };
      in
      {
        devShells.default = pkgs.mkShell {
          packages = with pkgs; [
            jdk21
            maven
            mysql84
            git
            curl
            jq
          ];

          JAVA_HOME = "${pkgs.jdk21}";

          shellHook = ''
            echo ""
            echo "========================================"
            echo "  Sistema de Inventario - Spring Boot"
            echo "========================================"
            echo ""
            echo "Java:"
            java -version
            echo ""
            echo "Maven:"
            mvn -version
            echo ""
            echo "Comandos disponibles:"
            echo "  mvn spring-boot:run  - Iniciar aplicación"
            echo "  mvn test             - Ejecutar pruebas"
            echo "  mysql -u root -p     - Conectar a MySQL"
            echo ""
          '';
        };
      }
    );
}
