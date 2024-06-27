# Guia para Compilar, Executar e Testar o Projeto

### 1. Compilar o Projeto
```bash
java .\src\app\java\main\App.java
```

### 2. Executar os testes
```bash
java -classpath ".;src/app/java/main;app/java/resources;src/test/java;src/lib/junit-4.13.2.jar" org.junit.runner.JUnitCore test.java.app.AppTest
```

# Guia para Compilar, Executar e Testar o Projeto com o Maven

### 1. Pré-requisitos

- Maven

### 2. Compilar o Projeto

```bash
mvn clean compile
```

### 3. Executar o Projeto

```bash
mvn exec:java
```

### 4. Executar os Testes

```bash
mvn test
```

