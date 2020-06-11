# Втора лабораториска вежба по Софтверско инженерство
## Никола Петровски, бр. на индекс 173089
### Група на код:
Ја добив групата на код 1

### Control Flow Graph
<img src="Control_Flow_Graph.png" width="300">

### Цикломатска комплексност
Цикломатската комплексност на овој код е 7, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=6, па цикломатската комплексност изнесува 7.

### Тест случаи според критериумот Every path
1. user == null - патека: A-K враќа false

2. user.getUsername == null (останатите параметри се било какви) - патека: A-B-K враќа false

3. user.getEmail() не содржи ни '@' ни '.' - патека: A-B-C-D1-D2-E-G-D3-D2-I-K враќа false

4. user.getEmail() има само '@', но не и '.' - патека: A-B-C-D1-D2-E-F-G-D3-D2-I-K враќа false

5. user.getEmail() има само '.', но не и '@' - патека: A-B-C-D1-D2-E-G-H-D3-D2-I-K враќа false

6. едно од сценаријата кога user.getEmail() е валиден email - патека: A-B-C-D1-D2-E-F-G-D3-D2-E-G-H-D3-D2-I-J враќа true

### Тест случаи според критериумот Every branch
1. user == null - гранки: <b>А-К</b>

2. user.getUsername() == nikola, user.getEmail() == nikola@finki.mk, AllUsers да не го содржи "nikola" - гранки: <b>A-B</b>, <b>B-C</b>, <b>C-D1</b>, <b>D1-D2</b>, <b>D2-E</b>, <b>E-F</b>, <b>F-G</b>, <b>G-H</b>, <b>G-D3</b>, <b>H-D3</b>, <b>E-G</b>, <b>D3-D2</b>, <b>D2-I</b>, <b>I-J</b>

3. user.getUsername() == null (останатите параметри се било какви) - гранки: A-B, <b>B-K</b>

4. user.getUsername() == nikola, user.getEmail == nikola@finki, AllUsers да не го содржи "nikola" - гранки: A-B, B-C, C-D1, D1-D2, D2-E, E-F, E-G, F-G, G-D3, D3 -D2, D2-I, <b>I-K</b>

### Објаснување на напишаните unit tests
... ...
