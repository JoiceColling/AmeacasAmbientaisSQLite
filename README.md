# AmeacasAmbientaisSQLite
**Projeto realizado na disciplina de Programação IV, dentro do curso de Ciência da Computação, no ano de 2023.**

Você foi contratado para desenvolver um aplicativo Android capaz de manter uma base de dados local que permita ao usuário armazenar ameaças ambientais flagradas pelo mesmo. Seu aplicativo deverá construir e popular uma base SQLite formada por uma única tabela de ameaças ambientais. Cada ameaça é formada por um código identificador numérico, um endereço, uma data e uma descrição. Seu aplicativo deve implementar 3 telas distintas que permitirão a manipulação dos dados armazenados na base SQLite.

![image](https://github.com/JoiceColling/AmeacasAmbientaisSQLite/assets/21341122/cbbebf37-6285-4055-8338-5615e9091403)

Requisitos da Parte 1

Na primeira parte seu projeto deverá implementar somente as interfaces gráficas necessárias. Observe as 3 telas exibidas como exemplo, procurando segui-las o mais próximo possível. As telas serão formadas pelas combinações dos seguintes componentes: EditText, TextView, ListView e Button. Note que na primeira etapa os componentes do tipo ListView não exibirão qualquer conteúdo.

Requisitos da Parte 2

A partir das interfaces construídas na parte 1, a parte 2 deverá implementar todas as funcionalidades necessárias ao projeto. Implemente uma classe para construir e gerenciar as operações relacionadas ao banco de dados e uma classe para representar instâncias de ameaças ambientais. Implemente também um adaptador que permita listar o conteúdo da base em um componente ListView. Implemente as transições entre as telas com base nos eventos gerados pelos botões. No ListView, o evento de clique curto deve levar a ameaça selecionada para edição, enquanto que o evento de clique longo deverá excluir a ameaça selecionada. Ao inserir ou editar uma ameaça, retorne para a tela inicial atualizando o ListView. Ao excluir uma ameaça, mantenha-se na tela inicial, atualizando o ListView.
