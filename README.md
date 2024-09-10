
# API Comercial

Projeto desenvolvido para a disciplina de Desenvolvimento de aplicações corporativas do quindo periodo do curso de ADS

---

## Descrição do domínio

## 1. Pedido
- Atributos: `Código`, `Valor`, `Data`, `Status`.
- Um **Pedido** pode ser feito por um **Fornecedor**.
- Um **Pedido** é solicitado por um **Funcionario**.
- Um **Pedido** contém produtos, que são representados pela entidade **Produto**.

## 2. Fornecedor
- Atributos: `CNPJ`, `Razão Social`, `Telefone`, `Email`.
- Faz pedidos de produtos.

## 3. Produto
- Atributos: `CodBarras`, `Descrição`, `QuantAtual`.
- Está associado ao **Pedido**. 
- Produtos são incluídos em uma **Venda**.

## 4. Venda
- Atributos: `Código`, `Data`, `Hora`, `ValorTotal`.
- É realizada por um **Funcionário**. 
- Possui varios produtos associados **Produto**.
- Uma **Venda** pode gerar um **Cupom** e possui uma **Conta**.

## 5. Funcionário
- Atributos: `CPF`, `Nome`, `Telefone`, `Endereço`, `Data de Admissão`, `Salário`, `Cargo`.
- Relacionado à **Venda** (ou seja, realiza vendas).
- Pode soliciar um **Pedido**.
- Um **Funcionário** pode ter vários **Dependente**.

## 6. Dependente
- Atributos: `Nome`, `Certidão de Nascimento`, `CPF`, `RG`.
- Um **Dependente** está associado a um **Funcionário**.

## 7. Cupom
- Atributos: `Nome`, `Telefone`, `Endereço`.
- Relacionado à **Venda** (gera um cupom).

## 8. Cartão
- Atributos: `Número`, `Nome`, `Bandeira`.
- O **Cartão** pode ser utilizado como forma de pagamento da **Conta** da **Venda**.

## 9. Conta
- Atributos: `Código`, `Valor`, `Data`.
- Uma **Venda** gera uma conta, que é utilizada para o pagamento pelo **Cliente**.
- O **Cliente** paga essa conta em uma data específica e pode ter descontos.

## 10. Cliente
- Atributos: `CPF`, `Nome`, `Telefone`, `Endereço`.
- Um **Cliente** realiza pagamentos de contas geradas pelas vendas.

## Relacionamentos Principais
- **Pedido** feito por **Fornecedor** contem **Produto**.
- **Venda** é realizada por um **Funcionário** e envolve **Produtos**.
- **Conta** é gerada por uma **Venda** e utilizada para pagamento por um **Cliente**.
- O **Cliente** pode pagar a conta utilizando um **Cartão**.
- Um **Funcionário** pode ter **Dependentes**.

---
