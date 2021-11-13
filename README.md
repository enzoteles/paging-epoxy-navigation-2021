# paging-epoxy-navigation-2021

## MVVM
Aqui usamos a arquitetura MVVM

<img width="908" alt="Screen Shot 2021-11-12 at 21 14 13" src="https://user-images.githubusercontent.com/5742609/141597565-fb276346-346a-4a08-a731-bbf9f0db890f.png">

## [Navigation](https://developer.android.com/guide/navigation?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lRKFs-Da1EV3vC3g_4wwykqHVqPaMpW3mNWgP4zQFWjVUus3E4M8lxoCWRsQAvD_BwE&gclsrc=aw.ds)
A navegação se refere às interações que permitem aos usuários navegar, entrar e sair de diferentes partes do conteúdo no aplicativo. O componente de navegação do Android Jetpack ajuda você a implementar a navegação, desde simples cliques em botões até padrões mais complexos, como barras de aplicativos e a gaveta de navegação. Esse componente também garante uma experiência do usuário consistente e previsível por meio da adesão a um conjunto de princípios estabelecido.

## [Epoxy] (https://github.com/airbnb/epoxy)
Usamos o Epoxy RecyclerView para fazer nossas listas

## [View Binding] (https://developer.android.com/topic/libraries/view-binding)
A vinculação de visualizações é um recurso que facilita a programação de códigos que interagem com visualizações. Quando a vinculação de visualizações é ativada em um módulo, ela gera uma classe de vinculação para cada arquivo de layout XML presente nesse módulo. A instância de uma classe de vinculação contém referências diretas a todas as visualizações que têm um código no layout correspondente.
Na maioria dos casos, a vinculação de visualizações substitui findViewById.

## [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lY-JDt6C1uh2Nr4r-1Q65tvKIkZJv8EA7kVkIyE0_UokpQYpw89IchoC4uoQAvD_BwE&gclsrc=aw.ds)
A classe ViewModel foi projetada para armazenar e gerenciar dados relacionados à IU considerando o ciclo de vida. A classe ViewModel permite que os dados sobrevivam às mudanças de configuração, como a rotação da tela.

## [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br)
LiveData é uma classe armazenadora de dados observável. Diferente de um observável comum, o LiveData conta com reconhecimento de ciclo de vida, ou seja, ele respeita o ciclo de vida de outros componentes do app, como atividades, fragmentos ou serviços. Esse reconhecimento garante que o LiveData atualize apenas os observadores de componente do app que estão em um estado ativo no ciclo de vida.

## [Corrotinas do Kotlin no Android](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lQzJ-3Eiv2px-E23Iq12uadkReNe2n_N2OGrnHSjp8wU1sJT4oDzpRoCb_sQAvD_BwE&gclsrc=aw.ds)
Uma corrotina é um padrão de projeto de simultaneidade que você pode usar no Android para simplificar o código que é executado de forma assíncrona. Corrotinas foram adicionadas ao Kotlin na versão 1.3 e são baseadas em conceitos estabelecidos de outras linguagens (link em inglês).
No Android, as corrotinas ajudam a gerenciar tarefas de longa duração que podem bloquear a linha de execução principal e fazer com que seu app pare de responder. Mais de 50% dos desenvolvedores profissionais que usam corrotinas notaram um aumento na produtividade. Este tópico descreve como você pode usar corrotinas do Kotlin para resolver esses problemas, permitindo criar um código de app mais simples e conciso.

## [Retrofit](https://square.github.io/retrofit/)
O retrofit torna nossa HTTP API em interface java 

## [Paging](https://developer.android.com/topic/libraries/architecture/paging?hl=pt-br)
A biblioteca Paging ajuda a carregar e exibir pequenos blocos de dados por vez. O carregamento de dados parciais sob demanda reduz o uso da largura de banda da rede e dos recursos do sistema.



