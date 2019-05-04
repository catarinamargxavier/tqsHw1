# tqsHw1
Trabalho individual da cadeira TQS - Testes e Qualidades de Software do curso de Engenharia Informática da Universidade de Aveiro.

## objetivo
Demonstrar a utilização de vários níveis de teste num projeto web, com multiplas camadas.

## projeto
Projeto para realizar a consulta da previsão meteorológica para os próximos dias, para uma determinada zona.
Componentes:
* página web minimalista (para interação)
* API Rest
* integração com fonte externa (API do IPMA + cache local)

## testes implementados
* unitários - **JUnit**
* isolamento de dependências com mocks - **JUnit + Mockito**
* integração (relativamente à API de serviços disponibilizados) - **REST-Assured e/ou Arquilian**
* funcional (sobre interface web) - **Selenium WebDriver**

## métricas de qualidade
* integração de análise - **SonarCloud** 
