# Calmeter

## API da aplicação gerenciadora de calorias ingeridas

### <font color="#00FF85">Endpoints 📖</font>

- Agenda
    - [Definir metas](#definir-metas)
    - [Consultar dias até o fim da meta e calorias consumidas até o momento](#consultar-dias-até-o-fim-da-meta)
    
- Gerenciar calorias do dia atual
    - [Adicionar porção/alimento](#adicionar-porçãoalimento)
    - [Editar porção/alimento](#editar-porçãoalimento)
    - [Detalhar porção/alimento](#detalhar-porçãoalimento)
    - [Deletar porção/alimento](#deletar-porçãoalimento)
    - [Adicionar refeição](#adicionar-refeição)
    - [Editar refeição](#editar-refeição)
    - [Deletar refeição](#deletar-refeição)

### Definir metas

`POST` 👉 <font color="#fce03f">**calmeter/api/meta**</font>

| <font color="#47a3ff">campo</font> | <font color="#aa31f5">tipo</font> | <font color="#ff5226">obrigatório</font> | <font color="#e0af0d">descrição</font> |
|:-----:|:----:|:-----------:|-----------|
| meta | `int` | ✔ | Valor de calorias diárias que o usuário planeja ingerir. Não deve ser menor que 0. 
| data_inicio | `date` | ✔ | Data em que o planejamento da meta se inicia. Não deve ser um dia passado.
| data_fim | `date` | ✔ | Data em que o planejamento da meta finaliza.

**👇 Corpo de requisição 👇**

```js
{
    "meta": 30000,
    "data_inicio": '2023-02-27',
    "data_fim": '2023-03-27'
}
```

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `201` | Dados da meta foram cadastrados com sucesso.
| `400` | Houve uma falha no cadastro dos dados.

### Consultar dias até o fim da meta

`GET` 👉 <font color="#fce03f">**calmeter/api/meta**</font>

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `200` | Dados da meta foram retornados com sucesso.
| `404` | Não há metas cadastradas até o momento.

**👇 Corpo de resposta 👇**

```js
{
    "meta": 30000,
    "data_inicio": '2023-02-27',
    "data_fim": '2023-03-27'
}
```

### Adicionar porção/alimento

`POST` 👉 <font color="#fce03f">**calmeter/api/alimento**</font>

| <font color="#47a3ff">campo</font> | <font color="#aa31f5">tipo</font> | <font color="#ff5226">obrigatório</font> | <font color="#e0af0d">descrição</font> |
|:-----:|:----:|:-----------:|-----------|
| nome | `string` | ✔ | Nome da(o) porção/alimento.
| descricao | `string` | ❌ | Descrição da(o) porção/alimento.
| calorias | `int` | ✔ | Número de calorias ingeridas naquela(e) porção/alimento.

**👇 Corpo de requisição 👇**

```js
{
    "nome": "Strogonoff",
    "descricao": "Filet mignon com ketchup, mostarda, creme de leite e champignon",
    "calorias": 1000
}
```

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `201` | Dados da meta foram cadastrados com sucesso.
| `400` | Houve uma falha no cadastro dos dados.

### Editar porção/alimento

`PUT` 👉 <font color="#fce03f">**calmeter/api/alimento/{id}**</font>

| <font color="#47a3ff">campo</font> | <font color="#aa31f5">tipo</font> | <font color="#ff5226">obrigatório</font> | <font color="#e0af0d">descrição</font> |
|:-----:|:----:|:-----------:|-----------|
| nome | `string` | ✔ | Nome da(o) porção/alimento.
| descricao | `string` | ❌ | Descrição da(o) porção/alimento.
| calorias | `int` | ✔ | Número de calorias ingeridas naquela(e) porção/alimento.

**👇 Corpo de requisição 👇**

```js
{
    "nome": "Strogonoff",
    "descricao": "Filet mignon com ketchup, mostarda, creme de leite e champignon",
    "calorias": 1000
}
```

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `200` | Dados da(o) porção/alimento foram atualizados com sucesso.
| `400` | Houve uma falha na atualização dos dados.

### Detalhar porção/alimento

`GET` 👉 <font color="#fce03f">**calmeter/api/alimento/{id}**</font>

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `200` | Dados da(o) porção/alimento foram retornados com sucesso.
| `404` | Não há porções/alimento com esse identificador até o momento.

**👇 Corpo de resposta 👇**

```js
{
    "nome": "Torresmo",
    "descricao": "Torresminho bem crocante!",
    "calorias": 500
}
```

### Deletar porção/alimento

`DELETE` 👉 <font color="#fce03f">**calmeter/api/alimento/{id}**</font>

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `204` | Dados da(o) porção/alimento foram deletados com sucesso.
| `404` | Não há porções/alimento com esse identificador até o momento.

### Adicionar refeição

`POST` 👉 <font color="#fce03f">**calmeter/api/refeicao**</font>

| <font color="#47a3ff">campo</font> | <font color="#aa31f5">tipo</font> | <font color="#ff5226">obrigatório</font> | <font color="#e0af0d">descrição</font> |
|:-----:|:----:|:-----------:|-----------|
| nome | `string` | ✔ | Nome da refeição.

**👇 Corpo de requisição 👇**

```js
{
    "nome": "Café da tarde"
}
```

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `201` | Dados da refeição foram cadastrados com sucesso.
| `400` | Houve uma falha no cadastro do alimento.

### Editar refeição

`PUT` 👉 <font color="#fce03f">**calmeter/api/refeicao/{id}**</font>

| <font color="#47a3ff">campo</font> | <font color="#aa31f5">tipo</font> | <font color="#ff5226">obrigatório</font> | <font color="#e0af0d">descrição</font> |
|:-----:|:----:|:-----------:|-----------|
| nome | `string` | ✔ | Nome da refeição.

**👇 Corpo de requisição 👇**

```js
{
    "nome": "Refeição intermediária"
}
```

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `200` | Dados da refeição foram atualizados com sucesso.
| `400` | Houve uma falha na atualização dos dados.

### Deletar refeição 

`DELETE` 👉 <font color="#fce03f">**calmeter/api/refeicao/{id}**</font>

**👇 Respostas 👇**

| <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|-----------|
| `204` | Dados da refeição foram deletados com sucesso.
| `404` | Não há uma refeição com esse identificador até o momento.
