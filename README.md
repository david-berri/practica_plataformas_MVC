## 🚀 Instrucciones de Ejecución

### Prerrequisitos

- Java JDK 17 o superior
- Git

### Paso 1: Clonar el Repositorio

git clone https://github.com/david-berri/practica_plataformas_MVC.git
cd practica_plataformas_MVC/practica_plataformas


### Paso 2: Dar Permisos de Ejecución a Gradle (Linux/Mac)

chmod +x gradlew


### Paso 3: Compilar el Proyecto

./gradlew build


### Paso 4: Ejecutar la Aplicación

./gradlew bootRun


La aplicación estará disponible en: **http://localhost:6002**

## Justificación de la Estrategia Git

Se implementó **Trunk-Based Development** en lugar de GitFlow debido a que el proyecto es individual y de alcance corto, lo que hace innecesaria la complejidad de mantener múltiples ramas permanentes (main, develop, release, hotfix). Trunk-Based permite integración continua más ágil mediante ramas feature de corta duración que se fusionan directamente a main vía Pull Request, alineándose perfectamente con el pipeline de CI/CD automatizado en GitHub Actions. Esta estrategia reduce la dificultad de gestión de ramas, acelera los desarrollos y mantiene la calidad del código mediante validación automatizada en cada pull request, siendo ideal ya que se priorizan entregas continuas.

## Herramientas del Pipeline CI/CD

El pipeline utiliza **GitHub Actions** como orquestador principal, ejecutando dos jobs: **Build y Test**, que emplea `actions/checkout@v4` para clonar el código, `actions/setup-java@v4` para configurar Java 17, y **Gradle Wrapper** para gestionar dependencias, compilar y ejecutar tests automáticamente en cada push o pull request; (2) **Release Automático**, que se dispara solo en merges a main, utiliza `git rev-list` para generar versionamiento semántico basado en el conteo de commits (formato v1.0.X), y `softprops/action-gh-release@v1` para crear releases en GitHub con descripción automática. Esta configuración garantiza que ningún código sea defectuoso y genera trazabilidad completa mediante releases.