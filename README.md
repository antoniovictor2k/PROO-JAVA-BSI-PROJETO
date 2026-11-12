# ESPECIFICAÇÃO INICIAL DO PROJETO DE SOFTWARE (PROO)
## Sistema SimulaVoz DETRAN: Inovação Social Digital em Acessibilidade para Exames de Trânsito

---

### IDENTIFICAÇÃO DO PROJETO

* **Disciplina:** Programação Orientada a Objetos (PROO)
* **Professor:** Kenji Kamei
* **Integrantes do Grupo:**
  * Antonio Victor Pereira Severiano — Matrícula: 2024014112
  * Bruno Gabriel Marcolino Moura — Matrícula: 2024014444
  * José Cauã Correia Silva — Matrícula: 2026010551
* **Data e Horário Limite de Entrega:**

---

## 1. VISÃO GERAL

### Descrição do Sistema
O **SimulaVoz DETRAN** é uma solução de software orientada a objetos focada no desenvolvimento de backend para inovação social digital, projetada no formato de um Bot assistivo interativo e serviço de conversão de mídia. Conforme estruturado nas diretrizes de projeto do grupo, o sistema tem como propósito central a recepção, extração e conversão de conteúdos textuais e visuais de questões de exames de trânsito em mídias de áudio sintetizado e audiodescrição estruturada.

A arquitetura orientada a objetos prioriza o desacoplamento e a manutenibilidade do backend, permitindo administrar o catálogo de questões, processar mídias de placas de sinalização, integrar motores de sintetização de voz (Text-to-Speech) e conduzir simulados sonoros interativos via Bot sem exigir alta complexidade na camada de frontend.

### Problema a ser Resolvido
Milhares de candidatos em processo de obtenção da Primeira Habilitação ou Renovação da Carteira Nacional de Habilitação (CNH) enfrentam severas barreiras de acessibilidade durante a preparação para a prova teórica de trânsito. Esse cenário afeta diretamente pessoas com deficiência visual (cegueira ou baixa visão), indivíduos com analfabetismo funcional, dislexia ou dificuldades severas de processamento leitor.

Os materiais de estudo convencionais focam exclusivamente em texto impresso ou digital acompanhado de imagens estáticas (placas e esquemas de cruzamento), sem oferecer recursos nativos de áudio ou audiodescrição. O **SimulaVoz DETRAN** atua diretamente como uma ferramenta de inclusão e inovação social digital, transformando os simulados de trânsito em uma experiência auditiva acessível e autônoma.

---

## 2. OBJETIVOS

### Objetivo Geral
Desenvolver uma aplicação orientada a objetos que automatize a extração, interpretação e conversão em áudio sintetizado de questões de simulados do DETRAN (enunciados, alternativas e imagens de sinalização), disponibilizando um serviço interativo de simulados auditivos para promover a acessibilidade e a inclusão social no processo de habilitação de trânsito.

### Objetivos Específicos
* **Módulo de Ingestão e Acervo:** Estruturar as classes de domínio para cadastro, categorização e armazenamento seguro de questões de trânsito e mídias de sinalização.
* **Módulo de Conversão Assistiva (OCR e TTS):** Integrar serviços de extração textual de imagem e conversão de texto para fala sintetizada, gerando arquivos sonoros reutilizáveis.
* **Módulo de Gestão de Simulados Auditivos:** Implementar a lógica de negócios responsável pela montagem de simulados, recepção de respostas do candidato e geração de gabaritos comentados em áudio.
* **Aplicação Rigorosa de Princípios de PROO:** Empregar com clareza os pilares da Programação Orientada a Objetos — encapsulamento, herança, polimorfismo, abstração, composição e agregação — garantindo um modelo estático e dinâmico escalável.

---

## 3. ATORES

A tabela a seguir apresenta os atores identificados no sistema, especificando seus perfis (usuários humanos ou sistemas externos) e suas respectivas responsabilidades operacionais.

| Ator | Tipo | Descrição e Responsabilidades |
| :--- | :--- | :--- |
| **Candidato / Usuário Final** | Usuário Humano | Candidato à CNH que interage com o Bot para realizar simulados auditivos, ouvir questões convertidas, responder alternativas e consultar gabaritos comentados. |
| **Administrador do Sistema** | Usuário Humano | Gestor responsável pelo cadastro de questões de trânsito, inclusão de audiodescrições de imagens, monitoramento do acervo e manutenção das mídias. |
| **Serviço Externo de TTS / OCR** | Sistema Externo | API ou motor computacional integrado para extração de caracteres em imagens e sintetização de áudio a partir do texto processado. |

---

## 4. ÉPICOS E HISTÓRIAS DE USUÁRIO

### Descrição dos Épicos
O sistema é organizado em três grandes blocos funcionais (Épicos):
1. **Épico 1: Gestão de Acervo e Conversão de Mídia** — Engloba a administração do acervo de questões de trânsito e o processamento assistivo de áudio e imagem.
2. **Épico 2: Execução de Simulados Auditivos e Bot** — Engloba a condução interativa dos simulados via Bot, recepção de respostas e cálculo de resultado com gabarito sonoro.
3. **Épico 3: Perfil e Preferências de Acessibilidade** — Engloba as configurações de ritmo de voz e histórico de desempenho do candidato.

### Funcionalidades dos Épicos

#### Épico 1: Gestão de Acervo e Conversão de Mídia
* **F1.1:** Cadastramento e categorização de questões teóricas por disciplina (Legislação, Direção Defensiva, Primeiros Socorros, Meio Ambiente e Mecânica).
* **F1.2:** Inclusão de audiodescrição estruturada para imagens de placas de regulamentação, advertência e situações de cruzamento.
* **F1.3:** Conversão automatizada de enunciados e alternativas em arquivos de áudio sintetizado.

#### Épico 2: Execução de Simulados Auditivos e Bot
* **F2.1:** Geração dinâmica de provas de simulado com sorteio de questões por categoria.
* **F2.2:** Transmissão sequencial dos áudios das perguntas e alternativas via interface Bot.
* **F2.3:** Registro e validação das respostas fornecidas pelo candidato.
* **F2.4:** Emissão do resultado final acompanhado de gabarito comentado em áudio.

#### Épico 3: Perfil e Preferências de Acessibilidade
* **F3.1:** Personalização de parâmetros de reprodução auditiva (velocidade da locução e tempo de pausa).
* **F3.2:** Armazenamento e consulta do histórico de simulados e evolução do candidato.

### Histórias de Usuário

| ID | Épico Relacionado | Estrutura da História de Usuário (Como / Quero / Para que) |
| :--- | :--- | :--- |
| **HU01** | Épico 1 | **Como** Candidato com deficiência visual ou dificuldade leitora, **eu quero** solicitar a conversão em áudio de uma questão de trânsito, **para que** eu possa compreender o enunciado sem depender de leitura textual. |
| **HU02** | Épico 1 | **Como** Administrador do sistema, **eu quero** cadastrar questões com imagens acompanhadas de audiodescrição detalhada, **para que** candidatos cegos compreendam a sinalização das placas. |
| **HU03** | Épico 2 | **Como** Candidato, **eu quero** iniciar um simulado auditivo completo pelo Bot, **para que** eu treine para o exame oficial do DETRAN ouvindo as perguntas e alternativas em sequência. |
| **HU04** | Épico 2 | **Como** Candidato, **eu quero** receber o resultado do simulado acompanhado do gabarito comentado em áudio, **para que** eu compreenda meus erros e reforce o aprendizado dos conceitos. |
| **HU05** | Épico 3 | **Como** Candidato, **eu quero** ajustar a velocidade de reprodução dos áudios das questões, **para que** a narração se adapte ao meu ritmo auditivo de compreensão. |

---

## 5. MODELAGEM UML

### 5.1 Diagrama de Sequência (Geral: Fluxo Principal de Simulado Auditivo)

O diagrama a seguir descreve a troca de mensagens e a dinâmica de interações entre os atores e os componentes de software no fluxo principal de execução de um simulado auditivo.

```text
[Candidato]         [BotController]     [GerenciadorSimulado]    [ConversorAudioService]   [MotorOCR_TTS]    [RepositorioQuestoes]
     |                     |                      |                         |                    |                     |
     |-- 1: solicitarSimulado(tipo) ------------->|                         |                    |                     |
     |                     |-- 2: criarSimulado()-------------------------->|                    |                     |
     |                     |                      |                         |-- 3: buscarQuestoes()----------------------->|
     |                     |                      |                         |<-- 4: retornarListaQuestoes()----------------|
     |                     |                      |-- 5: processarMidias() ->|                    |                     |
     |                     |                      |                         |-- 6: sintetizarTextoEImagem()-------------->|
     |                     |                      |                         |<-- 7: retornarArquivosAudio()---------------|
     |                     |                      |<-- 8: simuladoPronto ---|                    |                     |
     |                     |<-- 9: enviarAudioQuestao1()-------------------|                    |                     |
     |<-- 10: tocarAudioQuestao1()----------------|                         |                    |                     |
     |                     |                      |                         |                    |                     |
     |-- 11: enviarResposta(alternativa) -------->|                         |                    |                     |
     |                     |-- 12: registrarResposta()--------------------->|                    |                     |
     |                     |                      |                         |                    |                     |
     |-- 13: solicitarGabarito()----------------->|                         |                    |                     |
     |                     |-- 14: finalizarECalcularResultado()----------->|                    |                     |
     |                     |<-- 15: retornarResultadoEGabaritoAudio()-------|                    |                     |
     |<-- 16: enviarAudioGabarito()---------------|                         |                    |                     |
```

#### Detalhamento das Mensagens do Fluxo de Sequência:
1. O **Candidato** envia a mensagem `solicitarSimulado(tipo)` para a interface do `BotController`.
2. O `BotController` chama o método `criarSimulado()` no `GerenciadorSimulado`.
3. O `GerenciadorSimulado` solicita `buscarQuestoes()` ao `RepositorioQuestoes`.
4. O `RepositorioQuestoes` retorna a lista de objetos `Questao` selecionados.
5. O `GerenciadorSimulado` solicita o processamento de áudio via `processarMidias()`.
6. O `ConversorAudioService` invoca `sintetizarTextoEImagem()` no `MotorOCR_TTS`.
7. O `MotorOCR_TTS` devolve a coleção de objetos `ArquivoAudio`.
8. O `GerenciadorSimulado` notifica que a estrutura da prova auditiva está pronta.
9. O `BotController` envia a primeira mídia sonoras para o dispositivo do **Candidato**.
10. O **Candidato** executa a audição e envia a resposta selecionada.
11. O `BotController` armazena a alternativa escolhida via `registrarResposta()`.
12. Após a conclusão das questões, o `GerenciadorSimulado` calcula a nota final e disponibiliza o gabarito comentado em áudio para o **Candidato**.

---

### 5.2 Diagrama de Classes (Modelagem Estática de Domínio)

O modelo estático a seguir especifica a estrutura de classes, modificadores de visibilidade, atributos, métodos e os relacionamentos formais de Programação Orientada a Objetos.

```text
+-------------------------------------------------------+
|                   <<abstract>>                        |
|                     Usuario                           |
+-------------------------------------------------------+
| - id: int                                             |
| - nome: String                                        |
| - email: String                                       |
+-------------------------------------------------------+
| + autenticar(): boolean                               |
| # obterPerfil(): String                               |
+-------------------------------------------------------+
                           ^
                           | (Herança)
         +-----------------+-----------------+
         |                                   |
+---------------------------------+ +---------------------------------+
|            Candidato            | |          Administrador          |
+---------------------------------+ +---------------------------------+
| - nivelAcessibilidade: String   | | - nivelAcesso: int              |
| - velocidadeVozPref: float      | +---------------------------------+
+---------------------------------+ | + cadastrarQuestao(q): boolean  |
| + solicitarSimulado(): Simulado | | + removerQuestao(id): boolean   |
| + responder(qId, alt): void     | +---------------------------------+
+---------------------------------+

+-------------------------------------------------------+
|                        Questao                        |
+-------------------------------------------------------+
| - id: int                                             |
| - enunciadoTexto: String                              |
| - alternativas: List<String>                          |
| - alternativaCorreta: char                            |
| - categoria: String                                   |
+-------------------------------------------------------+
| + validarResposta(resposta: char): boolean            |
| + getTextoCompleto(): String                          |
+-------------------------------------------------------+
                           ^
                           | (Herança)
+-------------------------------------------------------+
|                  QuestaoComImagem                     |
+-------------------------------------------------------+
| - caminhoImagem: String                               |
| - descricaoAcessivelImagem: String                    |
+-------------------------------------------------------+
| + getDescricaoImagem(): String                        |
+-------------------------------------------------------+

+-------------------------------------------------------+
|                     ArquivoAudio                      |
+-------------------------------------------------------+
| - id: int                                             |
| - caminhoArquivo: String                              |
| - duracaoSegundos: int                                |
| - formato: String                                     |
+-------------------------------------------------------+
| + reproduzir(): void                                  |
| + getURLDownload(): String                            |
+-------------------------------------------------------+

+-------------------------------------------------------+
|                       Simulado                        |
+-------------------------------------------------------+
| - id: int                                             |
| - dataCriacao: Date                                   |
| - pontuacaoFinal: int                                 |
+-------------------------------------------------------+
| + adicionarQuestao(q: Questao): void                  |
| + gerarAudiosSimulado(): List<ArquivoAudio>           |
| + calcularResultado(): int                            |
+-------------------------------------------------------+

+-------------------------------------------------------+
|                ConversorAudioService                  |
+-------------------------------------------------------+
| - chaveAPI: String                                    |
| - idioma: String                                      |
+-------------------------------------------------------+
| + converterTextoParaAudio(t: String): ArquivoAudio    |
| + extrairEConverterImagem(img: String): ArquivoAudio  |
+-------------------------------------------------------+

+-------------------------------------------------------+
|                    BotController                      |
+-------------------------------------------------------+
| - statusSessao: String                                |
+-------------------------------------------------------+
| + receberComando(cmd: String): void                   |
| + enviarAudioResposta(a: ArquivoAudio): void          |
+-------------------------------------------------------+
```

#### Descrição das Classes, Atributos e Métodos
* **`Usuario` (Classe Abstrata):** Classe base que define os dados comuns de identificação.
  * Atributos privados: `- id: int`, `- nome: String`, `- email: String`.
  * Métodos: `+ autenticar(): boolean` (público) e `# obterPerfil(): String` (protegido).
* **`Candidato` (Subclasse de `Usuario`):** Representa o estudante.
  * Atributos privados: `- nivelAcessibilidade: String`, `- velocidadeVozPref: float`.
  * Métodos públicos: `+ solicitarSimulado(): Simulado`, `+ responder(qId: int, alt: char): void`.
* **`Administrador` (Subclasse de `Usuario`):** Representa o gestor de acervo.
  * Atributo privado: `- nivelAcesso: int`.
  * Métodos públicos: `+ cadastrarQuestao(q: Questao): boolean`, `+ removerQuestao(id: int): boolean`.
* **`Questao` (Classe Base):** Encapsula a estrutura de cada questão teórica de trânsito.
  * Atributos privados: `- id: int`, `- enunciadoTexto: String`, `- alternativas: List<String>`, `- alternativaCorreta: char`, `- categoria: String`.
  * Métodos públicos: `+ validarResposta(resposta: char): boolean`, `+ getTextoCompleto(): String`.
* **`QuestaoComImagem` (Subclasse de `Questao`):** Especialização de questão para placas de trânsito.
  * Atributos privados: `- caminhoImagem: String`, `- descricaoAcessivelImagem: String`.
  * Método público: `+ getDescricaoImagem(): String`.
* **`Simulado`:** Classe responsável por agrupar as questões e gerenciar o estado da prova.
  * Atributos privados: `- id: int`, `- dataCriacao: Date`, `- pontuacaoFinal: int`.
  * Métodos públicos: `+ adicionarQuestao(q: Questao): void`, `+ gerarAudiosSimulado(): List<ArquivoAudio>`, `+ calcularResultado(): int`.
* **`ArquivoAudio`:** Entidade que representa os arquivos sonoros sintetizados.
  * Atributos privados: `- id: int`, `- caminhoArquivo: String`, `- duracaoSegundos: int`, `- formato: String`.
  * Métodos públicos: `+ reproduzir(): void`, `+ getURLDownload(): String`.
* **`ConversorAudioService`:** Componente de serviço que abstrai a comunicação com motores externos de TTS/OCR.
  * Métodos públicos: `+ converterTextoParaAudio(t: String): ArquivoAudio`, `+ extrairEConverterImagem(img: String): ArquivoAudio`.
* **`BotController`:** Controller da camada de aplicação responsável por intermediar a sessão do usuário no Bot.

#### Mapeamento dos Relacionamentos Orientados a Objetos (PROO)
1. **Herança (Generalização / Especialização):**
   * `Candidato` e `Administrador` herdam diretamente de `Usuario`, reaproveitando atributos de autenticação e identificação.
   * `QuestaoComImagem` herda de `Questao`, estendendo a estrutura genérica da pergunta com atributos específicos de mídias de sinalização e audiodescrição.
2. **Composição (Relacionamento Forte de Parte-Todo):**
   * `Simulado` **contém** `Questao` via Composição. As instâncias de `Questao` organizadas na lista daquele simulado específico são agregadas à sessão da prova; a existência e ordenação das questões do teste dependem do ciclo de vida da instância do `Simulado`.
3. **Agregação (Relacionamento Fraco de Parte-Todo):**
   * `Simulado` **agrega** `ArquivoAudio`. Os arquivos de áudio sintetizados mantêm existência autônoma na aplicação (podendo ser armazenados em cache ou repositório de mídias para reutilização por outros candidatos de forma independente).
4. **Associação:**
   * `BotController` associa-se a `Candidato` (gerenciamento da sessão ativa) e a `ConversorAudioService` (solicitação das conversões de áudio a serem entregues ao usuário).
