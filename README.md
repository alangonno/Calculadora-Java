# 🔢 Calculadora com Java Swing

Este projeto é uma implementação de uma calculadora funcional em Java, com foco na utilização de boas práticas de programação, como a separação de responsabilidades (Model-View) e o padrão de projeto Observer. A interface gráfica foi construída utilizando a biblioteca nativa Java Swing.

## ✨ Funcionalidades

* **Operações Básicas:** Realiza as quatro operações matemáticas fundamentais (soma, subtração, multiplicação e divisão).
* **Interface Gráfica:** Interface de usuário limpa e intuitiva, inspirada em calculadoras padrão.
* **Display Interativo:** O display atualiza em tempo real conforme o usuário digita os números e as operações.
* **Lógica de Memória:** Armazena valores e operações pendentes para realizar cálculos sequenciais.

## 🏛️ Arquitetura e Padrões de Projeto

O código foi estruturado para separar a lógica de negócio da interface de usuário, facilitando a manutenção e a escalabilidade.

### **Model-View-Controller (MVC)**

O projeto segue uma abordagem baseada no padrão MVC:

* **Model (`br.com.alan.calc.modelo`):** A classe `Memoria.java` contém toda a lógica de negócio. Ela armazena o estado atual da calculadora (valor no display, operação pendente, etc.) e executa os cálculos, sem ter conhecimento de como esses dados serão exibidos.

* **View (`br.com.alan.calc.visao`):** As classes `Calculadora.java`, `Display.java`, `Teclado.java` e `Botao.java` são responsáveis por construir e exibir a interface gráfica para o usuário. Elas enviam os comandos do usuário (cliques nos botões) para o Model.

### **Padrão Observer**

Para garantir que a interface gráfica (View) reaja automaticamente às mudanças na lógica (Model), foi utilizado o padrão Observer.

* A classe `Display` atua como um **"Observador"** (`MemoriaObservador`).
* A classe `Memoria` é o **"Observado"**.
* Toda vez que um valor é alterado na `Memoria`, ela notifica seus observadores. O `Display`, ao ser notificado, atualiza o texto que exibe, garantindo que a interface esteja sempre sincronizada com o estado interno do sistema.

## 🛠️ Tecnologias Utilizadas

* **Java Swing**
    * A interface gráfica da calculadora foi totalmente desenvolvida com a biblioteca Swing, que faz parte do Java SE. É uma ferramenta poderosa para criar aplicações desktop interativas.
