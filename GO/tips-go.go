
================= GOLANG / GO =================

2009
Robert Griesemer / Rob Pike, Ken Thompson
Liberado codigo pra uso em 2012

GOROOT
GOPATH

comando verificar algumas variaveis do GO
go env

Na pasta dos arquivos com o prompt esse comando abre o VSCode
code .

Executar
ctrl + alt + N

Parar 
ctrl + alt + M


================= Comandos =================

Comentario

// linha
/* comentario bloco */

Comando help
    go
    go help
    go version 
    godoc -http=:6060(porta desejada)
    go env
    go doc cmd/vet
    go doc cmd/vet nome-do-arquivo.go
    go vet comandos.go
    go build comandos.go
    ./comandos 
    go run comandos.go
    go run *.go


================= Const / Var =================

const  nome-contante typo = valor
const PI float64 = 3.14
var raio = 3.2
area := PI * math.Pow(raio, 2)

const(
    a = 1
    b = 2
)
var (
    c = 3
    d = 4
)

var e, f bool = true, false
g, h, i := 2, false, "epa!"


================= fmt =================

fmt.Print( printa na mesma linha )
fmt.PrintLn( quebra linha no print )
fmt.Sprint( converte em uma string )
fnt.Printf( print formatado aceira o %.2f %v, x)
\n quebra linha


================= Tipos VAR =================

Varifica o tipo de var
    reflect.TypeOf(3200)

    float32
    float64
    true/false boolean
    string
    int32
    int64
    
    len()

================= Conversoes =================

    float64()
    int()
    string()

converter inteiro em string
    strconv.Itoa(123)

String em inteiro
    strconv.Atoi("123")

Converte em boolean
    strconv.ParseBool


================= funcoes basicas =================

func nomeFuncao(){}

func nomeFuncao(nomeParametro stirng, segundoParametro string) string {
    return nomeParametro + segundoParametro
}


================= Operadores =================

soma +
subtrai -
divisao /
mitiplica *
modulo(resto da divisao) %
bitwisw(valor binario) & 
OU |
xor ^
math.Max( float64(x), float64(y))
math.Min(x, y)
math.Pow(x, y)

ATRIBUICAO
    recebe = 
    cria recebe :=
    adiciona +=
    diminui -=
    dividida /=
    mitiplicada *=
    resto %=
    x, y := 1, 2
    

================= Operadores Relacionais =================

==
!=
<
>
<=
>=
Equal()

type Pessoa struct {
    Nome string
}

p1 := Pessoa{"nome"}


================= Operadores Logicos =================

func compras(trab1, trab2 bool) (bool, bool, bool) {

    comprarTv50 := trab1 && trab2
    comprarTV32 := trab1 != trab2
    comprarSorvete := trab1 || trab2

    return comprarTv50, comprarTV32, comprarSorvete
}


================= Operadores unarios =================

imcremento e decremento ++ --



================= Ponteiro =================

i := 1
var p *int = nil
p = &i
*p++  (* pega o valor do ponteiro)
&i (pega o endereco de i)


================= Controles =================
================= Controles =================
================= if else =================

if nota >= 7 {
    ...
} else {
    ...
}
--------------------------

if nota >= 7 {
    ...
} else if nota <= 5 {
    ...
} else {
    ...
}
--------------------------

if i := numeroAleatorio(); i > 5 {
    ...
} else {
    ...
}

================= for =================

for i := 0; i <= 20; i += 2 {
    ...
}

================= Switch =================

switch nota {
    case 10: 
        fallthrough
    case 9:
        return "9"
    case 8, 7;:
        retrun "B"
    case 6,5:
        return "c"
    case 4,3:
        return "d"
    case 2,1,0:
        return "e"
    default: "Nota invalida"
}

switch { // switch true
    case x == 9 : 
        fmt:PrintLn("Bom dia")
    case x > 9 :
        fmt:PrintLn("Boa tarde")
    case x < 9 :
        fmt:PrintLn("Bom noite")
}


func tipo(i interface{}) string {

    switch i.(type){
        case int: 
            return "inteirop"
        case float32, float64:
            return "real"
        case string:
            rerun "string"
        case func():
            return "funcao"
        default: 
            return "nao sei"
    }
}


=================  Arrays =================

nome do array, tamanho, tipo 
    var notas [3] float32
    notas[0], notas[1], notas[2] = 7.8, 4.3, 9.1

    total:= 0.0
    for i:=0, i < len(notas); i++ {

        total += notas[i]

    } 
    media := total / float64(len(notas))
    fmt.Print("Media %2f\n", media)


for range

    numeros := [...] int{1,2,3,4,5}

    for i, numero := range numeros {
        fmt.Printf(" %d %d ", i+1, numero)
    }

    for _, numero := range numeros {
        fmt.Printf("%d ", numero)
    }

mostra somente o indice e nao o valor
    for indice := range numeros {
        fmt.Printf("%d ", indice)
    }


=================  Slices =================

a1 := [3]int{1,2,3} // array
s1 := []int{1,2,3} // slice

a2 := [5]int{1,2,3,4,5}
s2 := a2[1:3] // pega o valor 2 3 do array a2
s3 := a2[:2]  // pega o valor 1 2 do array a2
s4 := s2[:1]  // pega o valor 2 do slice s2

* Slice Make

    s := make([]int, 10)
    s[9] = 12

            (tipo, tamanho, capacidade)
    s = make([]int, 10, 20)

    len()  mostra o tamanho do slice
    cap()  mostra a capacidade do slice

    s = append(s, 1,2,3,4,5,6,7,8,9,0)

* append copy

    array1 := [3]int{1,2,3}
    var slice1 []int

    // array1 = append(slice1, 4,5,6) isso aqui ?? invalido
    slice1 = append(slice1, 4, 5, 6)
    
    slice2 := make([]int, 2)
    copy(slice2, slice1)

    append = adiciona itens
    copy = copia elementos somente no slice


=================  MAP =================

//var aprovados map[int]string

aprovados := make(map[int]string)
aprovados[123123123] = "Maria"
aprovados[123123124] = "Pedro"
aprovados[123123125] = "Jose"

for cpf, nome := range aprovados {

    fmt.Printf("%s (cpf: %d)\n", nome, cpf)
}

        map,        chave
delete(aprovados, 123123123)


funcFuncionarios := map[string]float64{
    "joao": 10.5,
    "Pedro": 11.5,
}

---

funcFuncionarios[joao] = 12.5
delete(funcFuncionarios, "naoexistente")

for nome, salario := range funcFuncionarios {
    
    fmt.PrintLn(nome, salario)
}

--- map aninhado

funcPorLetra := map[string]map[string]float64{
    "G": {
        "Gabriela" : 10.5,
        "Guga": 11.5,
    },
    "J": {
        "Jose": 15.0,
    },
    "P": {
        "Pedro": 12.1,
    },
}

Deleta todos dentro da letra P
    delete(funcPorLetra, "P")

for letra, funcs := range funcPorLetra {

    fmt.PrintLn(letra, funcs)
}


=================  Funcoes  =================

--- basicas

    func nome-funcao(){

        fmt.Print("teste")
    }

    func f2(p1 string, p2 string){

        fmt.Printf("F2: %s %s \n", p1, p2)
    }

    func f3() string {
        return "F3"
    }

    func f4(p1, p2 string) string {

        return fmt.Printf("F4: %s %s", p1, p2)
    }

    func f5() (string, string) {
        return "retorno 1", "retorno 2"
    }

--- Pilhas de func

Mostra a pilha de stack
    debug.PrintStack()

func trocar(p1, p2 int) (segundo, primeiro int){
    segundo = p2
    primeiro = p1
    return // retorno limpo
}

var soma = func(a, b int) int {
    return a + b 
}

---

func multiplica(a, b int) int {
    return a * b
}

func exec(funcao func(int, int) int, p1, p2 int) int {
    return funcao(p1, p2)
}

resultado := exec(multiplica, 3, 4)
fmt.PrintLn(resultado) = 12


-- funcoes variaticas

func media(numeros ...float64) float64 {

    total := 0.0
    for _, num := range numeros {

        total += num
    }
    return total / float64(len(numeros))
}

---

func imprimeAprovados(aprovados ...string) {

    for i, aprovado := range imprimeAprovados {
        fmt.Printf("%d %s\n", i+1, aprovado)
    }
}

func main(){

    aprovados := []string{"Joao",  "Maria", "Pedro"}
    imprimeAprovados(aprovados...)
}

--- closure (funcao)

func closure() func() {
    x := 10
    var funcao = func(){
        fmt.PrintLn(x)
    }
    return funcao
}

func main(){

    x:= 20
    fmt.PrintLn(x)

    funcaox := closure
    fmt.PrintLn(funcaox)
}

--- Recursividade

func fatorial (n int) (int, error) {

    switch{
        case n < 0:
            return -1, fmt.Errorf("numero invalido : %d", n)
        case n == 0:
            return 1, nil
        default:
            fatorialAnterior := fatorial(n-1)
            return n * fatorialAnterior, nil
    }
}

func main() {

    resultado, _ := fatorial(5)
    fmnt.PrintLn(resultado)

    _, err := fatorial(-4)
    if err != nil {
        fmnt.PrintLn(err)
    }
}

--- Recursividade simples

uint = tipo inteiro positvo


func fatorial (n int) uint {

    switch{
        case n == 0:
            return 1, nil
        default:
            return n * fatorial(n-1)
    }
}

func main() {

    resultado:= fatorial(5)
    fmnt.PrintLn(resultado)
}


--- Defer  (executa no final antes do return )

func obterValorAprovado(numero int) int {

    defer fmt.PrintLn(" fim ")

    if numero > 5000 {
        fmt.PrintLn("Varlor alto ...")
        return 5000
    } else {
        fmt.PrintLn("Varlor baixo ...")
        return numero
    }
}

func main() {

    fmt.PrintLn(obterValorAprovado(6000))

    /*  Order de execulcao
    *   
    *   valor alto ...
    *   fim
    *   5000
    *
    */
}


--- Ponteiro para funcao

func inc1(n int){
    n++
}

// revisao: um ponteiro e representado por um *
func inc2(n *int){

    // revisao: * e usado para desreferenciar , ou seja 
    // ter acesso ao valor no qual o ponteiro aponta 
    *n++
}

func main(){

    n:= 1

    inc1(n) // por valor, capia do valor para a funcao
    fmt.PrintLn(n)

    // revisao: & usado para obter o endereco da variavel
    inc2(&n) // por referencia
    fmt.PrintLn(n)
}


--- init

// essa funcao ?? axecutada antes mesmo da funcao main()
// todo arquivo pode ter a func init()
func init(){
    fmt.PrintLn("Inicializando ...")
}

func main(){
    fmt.PrintLn("Main ...")
}


=================  Sistemas de tipos  ================= 

--- Struct

type produto struct {
    nome string
    preco float64
    desconto float64
}

// metodo: funcao com receiver (receptor)

func (p produto) precoComDesconto() float64{
    return p.preco * (1 - p.desconto)
}

func main() {

    var produto1 produto
    produto1 = produto {
        nome: "Lapis",
        preco: 1,79,
        desconto: 0.05,
    }
    fmt.PrintLn(produto1, produto1.precoComDesconto())

    produto2 = produto {"Notbook", 1989.90, 0.10}
    fmt.PrintLn(produto2, produto2.precoComDesconto())
}


--- Struct aninhada

type item struct {
    produtoId int
    qtde int
    preco float64
}

type pedido struct {
    userId int
    itens []item
}

func (p pedido) valorTotal() float64{

    total := 0
    for _, item := range p.itens {
        total += item.preco * float64(item.qtde)
    }
    return total
}

func main(){

    pedido := pedido{
        userId: 1,
        itens: []item {
            item{1, 2, 12, 12.10}, // ou item{produtoId: 1, qtde: 2, preco: 12.10}
            item{2, 1, 23, 49},
            item{11, 100, 3.13},
        },
    }

    fmt.Printf("Valor total do pedido ?? R$ %2f", pedido.valorTotal())
}


--- Struct fun????es (GET / SET)

type pessoa struct {
    nome string
    sobrenome string
}

func (p pessoa) getNomeCompleto() string{
    return p.nome + " " + p.sobrenome
}

func (p *pessoa) setNomeCompleto(nomeCompleto string) {
    partes := strings.Split(nomeCompleto, " ")
    p.nome = partes[0]
    p.sobrenome = partes[1]
}

func main(){
    
    p1 := pessoa{"Pedro", "Silva"}
    fmt.PrintLn(p1.getNomeCompleto())

    p1.setNomeCompleto("Maria Pereira")
    fmt.PrintLn(p1.getNomeCompleto())
}


--- Struct composicao/pseudo heranca


type carro struct {
    nome string
    valocidadeAtual int
}

type ferrari struct {
    carro // campos anonimos
    turboLigado bool
}

func main(){
    
    f := ferrari{}
    f.nome = "F48"
    f.valocidadeAtual = 0
    f.turboLigado = true

    fmt.Printf("A ferrari %s esta com o turbo ligado %v\n", f.nome, f.turboLigado)
    fmt.PrintLn(f)
}


--- Struct tipo personalizado

type nota float64

func(n nota) entre(inicio, fim float64) bool {

    return float64(n) >= inicio && float64 <= fim
}

func notaParaConceito(n nota) string {

    if n.entre(9.0, 10.0){
        return "A"
    } else if n.entre(7.0, 8.99){
        return "B"
    } else if n.entre(5.0, 7.99){
        return "C"
    } else if n.entre(3.0, 4.99){
        return "D"
    } else {
        return "E"
    }
}

func notaParaConceito2(n nota) string {

    switch {
        
        case n.entre(9.0, 10.0): return "A" 
        case n.entre(7.0, 8.99): return "B"
        case n.entre(5.0, 7.99): return "C"
        case n.entre(3.0, 4.99): return "D"
        default: return "E"
    }
}

func main(){

    fmt.PrintLn(notaParaConceito(9.8))
    fmt.PrintLn(notaParaConceito(6.9))
    fmt.PrintLn(notaParaConceito(2.1))

    fmt.PrintLn(notaParaConceito2(9.8))
    fmt.PrintLn(notaParaConceito2(6.9))
    fmt.PrintLn(notaParaConceito2(2.1))
}


--- Interfaces

type imprimivel interface {
    toString() string
}

type pessoa struct {
    nome string
    sobrenome string
}

type produto struct {
    nome string
    preco float64
}

func (p pessoa) toString() string {
    return p.nome + " " + sobrenome
}

func (p produto) toString() string {
    return fmt.Sprint("%s - R$ $.2f", p.nome, p.preco)
}

func imprimir(x imprimivel){
    fmt.PrintLn(x.toString())
}

func main(){

    var coisa imprimivel = pessoa("Roberto", "Silva")
    fmt.PrintLn(coisa.toString())
    imprimir(coisa)

    coisa = produto{"calca jeans", 79.9}
    fmt.PrintLn(coisa.toString())
    imprimir(coisa)

    p2 := produto{"calca jeans", 79.9}
    imprimir(p2)
}


--- Interfaces 02

type esportivo interface {
    ligarTurbo()
}

type ferrari struct {
    moddelo string
    turboLigado bool
    velocidadeAtual int
}

func (f *ferrari) ligarTurbo(){
    f.turboLigado = true
}

func main(){

    carro1 = ferrari{"f40", false, 0}
    carro1.ligarTurbo()

    carro2 esportivo = &ferrari{"f48", false, 0}
    carro2.ligarTurbo()

    fmt.PrintLn(carro1, carro2)
}

--- composicao de Interfaces 

type esportivo interface {
    ligarTurbo()
}

type luxuoso interface {
    fazerBaliza()
}

type esportivoLuxuoso interface {
    esportivo
    luxuoso
    // pode add novos metodos
}

type bmw7 struct{}

func (b bmw7) ligarTurbo() {
    fmt.PrintLn("Turbo ...")
}

func (b bmw7) fazerBaliza(){
    fmt.PrintLn("Baliza ...")
}

func main(){

    var b esportivoLuxuoso = bmw7{}
    b.ligarTurbo()
    b.fazerBaliza()
}


--- tipos de Interfaces

type  curso struct {
    nome string
}

func main() {

    var coisa interface{}
    fmt.PrintLn(coisa)

    coisa = 3
    fmt.PrintLn(coisa)

    type dinamico interface{}
    var coisa2 dinamico = "Opa"
    fmt.PrintLn(coisa2)

    coisa2 = true
    fmt.PrintLn(coisa2)

    coisa2 = curso{"Golang: Explorando a linguagem"}
    fmt.PrintLn(coisa2)
}


--- Converter struct em json

type produto struct {
    id int `json:"id"`
    Nome string `json:"nome"`
    Preco float64 `json:"preco"`
    Tags []string `json:"tags"`
}

func main(){

    // struct pra json
    p1 := produto{1, "Notbook", 1899.99, []string{"Promocao", "Eletronico"}}
    p1Json, _ := json.Marshal(p1)
    fmt.PrintLn(string(p1Json))

    // json pra struct
    var p2 produto
    jsonString := `{"id":2, "nome": "Caneta", "preco": 8.90, "tags":["Papelaria", "Importado"]}`
    json.Unmarshal([]byte(jsonString), &p2)
    fmt.PrintLn(p2.Tags[1]))
}


--- Executando multiplos arquivos no terminal 
    go run arquivo1.go arquivo2.go

--- Pacotes e Visibilidades

package main

// Iniciando com letra maiuscula ?? PUBLICO
// Inicializando com letra minuscula ?? PRIVADO
// ex :
// Ponto - gerara algo publico
// ponto ou _Ponto - gerara algo privado

// Ponto representa uma codernada no plano cartesiano
type Ponto struct {
    x float64
    y float64
}

func catetos(a, b Ponto) (cx, cy float64){
    cx = math.Abs(b.x - a.x)
    cy = math.Abs(b.y - a.y)
    return
}

// Distancia e responsavel para calcular s distancia linear entre dois pontos
func Distancia(a, b Ponto) float64 {
    cx, cy := cateto(a,b)
    return math.Sqrt(math.Pow(cx, 2) + math.Pow(cy, 2))
}



=================  Pacotes / src / GOPATH ================= 

criar pastas dentro da pasta GO

GO/SRC/github.com/cod3rcusrsos/area/area.go

package area

import "math" 

// Pi ?? uma proporcao numerica definida pela relacao entre
// o periodo de uma circuferencia e seu diametro
const Pi = 3.1416

// Circ ?? responsavel por calcular a area da circuferencia
func Circ(raio float64) float64 {
    return math.Pow(raio, 2) * Pi
}

// Rect ?? responsavel por calcular a area de um retangulo
func Rect(base, altura float64) float64 {
    return base + altura
}

// ?? ?? visivel
func _TrianguloEq(base, altura float64) float64 {
    return (base * altura) / 2 
}


--- no projeto o uso da biblioteca criada

package main

// ao salvar importa automaticamente
import {
    "fmt"
    "github.com/cod3rcursos/area"
}

func main(){
    fmt.PrintLn(area.Circ(6.0))
}

// puxar pacote via comando
go get -u github.com/cod3rcursos/goarea

// uso

package main

func main(){
    goarea.Circ(4.0)
}


=================  Comcorrencia x  Paralelismo ================= 

    - GO ?? uma linguagem concorrente
    - Concorrencia , ?? uma forma de estruturar o seu progrma
    - Modelar sistema com concorrencia.
    

=================  GO Routine - goroutine ================= 

package main

func fale(pessoa, texto string, qtde int) {
    for i := 0; i < qtde; i++ {
        time.Sleep(time.Second)
        fmt.Printf("%s : (interacai %d)\n", pessoa, texto, i+1)
    }
}

func main(){

    //fale("Maria", "Pq vc nao fala comigo ? ", 3)
    //fale("Joao", "So posso falar depois de vc !", 1)

    //go fale("Maria", "Ei ...", 500)
    //go fale("Joao", "Opa ...", 500)

    go fale("Maria", "Entendi !!!", 10)
    fale("Joao", "Parbens", 5)
}


================= channel ================= 

package main

func main(){

    ch := make(chan int, 1)
    
    ch <- 1 // enviando dado para um canal
    <- ch // lendo dado do canal
    ch <- 2
    fmt.PrintLn(<-ch)
    
}


================= goroutine + channel / deadLock ================= 

package main


func doisTresQuatroVezes(base int, c chan int){

    time.Sleep(time.Second)
    c <- 2 * base

    time.Sleep(time.Second)
    c <- 3 * base

    time.Sleep(3 * time.Second)
    c <- 4 * base
}

func main(){

    c := make(chan int)
    go doisTresQuatroVezes(2, c)

    a, b := <-c, <-C
    fmt.PrintLn(a,b)

    fmt.PrintLn(<-c)
}


================= Channel Usando Range e Close ================= 

// primos

package main

func isPrimo(num int){

    for i := 2; i< num; i++ {
        if num%i == 0 {
            return false
        }
    }
    return true
}

func primos(n int, c chan int){

    inicio := 2
    for i := 0; i < n; i++ {
        for primo := inicio; ; primo++ {
            if isPrimo(primo) {
                c <- primo
                inicio = primo + 1
                time.Sleep(time.Millisecond * 100)
                break
            }
        }
    }
    close(c)
}

func main(){

    c := make(chan int, 30)
    go primos(cap(c), c)
    for primo := range c {
        fmt.Printf("%d ", primo)
    }
    fmt.PrintLn("Fim!")
}


================= Concorrencia / Generators ================= 

package main

func titulo(urls ...string) <-chan string{

    c := make(chan string)
    for _, url := range urls {

        go func(url string){

            resp, _ := http.Get(url)
            html, _ := ioutil.ReadAll(resp.Body)

            r, _ := regexp.Compile("<title>(.*?)<\\/title>")
            c <- r.FindStringSubmatch(string(html))[1]
        }(url)
    }
    return c
}

func main(){

    t1 := titulo("https://www.cod3r.com.br", "https://www.google.com")
    t2 := titulo("https://www.amazon.com", "https://www.youtube.com.br")

    fmt.PrintLn("Primeiros colocados:", <-t1, " | ", <-t2)
    fmt.PrintLn("Segundos colocados:", <-t1, " | ", <-t2)
}

================= Concorrencia /  Multiplexador ================= 

Junta dois channels em um sobrenome


package main

func encaminhar(origem <-chan string, destino chan string){
    
    for {
        destino <- <-origem
    }
}

func juntar(entrada1, entrada2 <-chan string) <-chan string{

    c := make(chan string)
    go encaminhar(entrada1, c)
    go encaminhar(entrada2, c)
    return c
}

func main(){

    c := juntar(
        html.Titulo("https://www.cod3r.com.br", "https://www.google.com"),
        html.Titulo("https://www.amazon.com", "https://www.youtube.com.br"),
    )
    fmt.PrintLn(<-c, "|", <-c)
    fmt.PrintLn(<-c, "|", <-c)
}

================= Comcorrencia /  Estrutura de controle Select ================= 

package main

func oMaisRapido(url1, url2, url3 string) string{

    c1 := html.Titulo(url1) 
    c2 := html.Titulo(url2) 
    c3 := html.Titulo(url3)

    select {
        case t1 := <-c1:
            return t1
        case t2 := <-c2:
            return t2
        case t3 := <-c3:
            return t3
        case <-time.After(1000 * time.Millisecind):
            return "Todos perderam!"
        // default:
        //     return "Sem responta ainda!"
    }
}

func main(){

    campeao := oMaisRapido(
        "https://www.cod3r.com.br", 
        "https://www.google.com",
        "https://www.amazon.com",
    )
    fmt.PrintLn(campeao)
}


================= Comcorrencia /  Estrutura de controle Select + Multiplexador ================= 

package main

func falar(pessa string) <-chan string {
    
    c:= make(chan string)
    go func(){
        for i := 0; i < 3; i++ {
            time.Sleep(time.Second)
            c <- fmt.Sprintf("%s falando: %d", pessoa, i)
        }
    }()
    return c
}

func nuntar(entrada1, entrada2 <-chan string) <-chan string {

    c := make(chan string)
    go func(){
        for {
            select {
            case s := <-entrada1: c <- s
            case s := <-entrada2: c <- s
            }
        }
    }()
    return c
}

func main(){

    c := juntar(falar("JOao"), falar("Maria"))

    fmt.PrintLn(<-c, <-c)
    fmt.PrintLn(<-c, <-c)
    fmt.PrintLn(<-c, <-c)
}


================= Teste Unitario ================= 

Via comando
go test
go test ./...
go test -v
go test std

Cobertura de testes 
    go test -cover 
    go test -coverprofile=resultado.out
    go tool cover -func=resultado.out
    go tool cover -html=resultado.out

+INFOS na pasta test


================= Banco de dados ================= 

-- Criando schema de tabelas

go get -u github.com/go-sql-driver/mysql 

package main

import(
   _ "github.com/go-sql-driver/mysql"
)

func exec(db *sql.DB, sql string) sql.Result {

    result, err := db.Exec(sql)
    if err != nil {
        panic(err)
    }
    return result
}

func main(){

    db, err := sql.Open("mysql", "root:123456@/")
    if err != nil {
        panic(err)
    }
    defer db.close()

    exec(db, "create database if not exists cursogo")
    exec(db, "use cursogo")
    exec(db, "drop table if exists usuarios")
    exec(db, `create table usuarios(
        id integer auto_increment,
        nome varchar(80),
        PRIMARY KEY(id)
    )`)
}


--- Inserts

package main

import(
    _ "github.com/go-sql-driver/mysql"
)

func main(){

    db, erro := sql.Open("mysql", "root:123456@/cursogo")
    if err != nil {
        panic(err)
    }
    defer db.close()

    stmt, _ := db.Prepare("insert into usuario(nome) values(?)")
    stmt.Exec("Maria")
    stmt.Exec("Joao")

    res, _ := stmt.Exec("Pedro")

    id, _ := res.LastInsertId()
    fmt.PrintLn(id)

    linhas, err := res.RowsAffected()
    ftm.PrintLn(linhas)
}

--- Insert transacao


package main

import(
    "database/sql"
    "log"
    _ "github.com/go-sql-driver/mysql"
)

func main(){

    db, erro := sql.Open("mysql", "root:123456@/cursogo")
    if err != nil {
        panic(err)
    }
    defer db.close()

    tx, _ := db.Begin()
    stmt, _ := tx.Prepare("insert into usuarios(id, nome) values(?,?)")

    stmt.Exec(2000, "Bia")
    stmt.Exec(2001, "Carlos")
    _, err := stmt.Exec(1, "Thiago") // chave invalida

    if err != nil {
        tx.Rollback()
        log.Fatal(err)
    }
    tx.Commit()
}


--- Update e delete

package main

import(
    "database/sql"
    "log"
    _ "github.com/go-sql-driver/mysql"
)

func main(){

    db, erro := sql.Open("mysql", "root:123456@/cursogo")
    if err != nil {
        panic(err)
    }
    defer db.close()

    // Update
    stmt, _ := db.Prepare("update usuarios set nome = ? where id = ?")
    stmt.Exec("Nome1", 1)
    stmt.Exec("Nome2", 2)

    // Delete
    stmt, _ := db.Prepare("delete from usuarios where id = ?")
    stmt.Exec(1)
    stmt.Exec(2)
    
}

--- Select

package main

import(
    "database/sql"
    "log"
    _ "github.com/go-sql-driver/mysql"
)

type usuario struct {
    id int
    nome string
}

func main(){

    db, erro := sql.Open("mysql", "root:123456@/cursogo")
    if err != nil {
        panic(err)
    }
    defer db.close()

    // Select
    rows, _ := db.Query("select * from usuarios where id > ?", 5)
    // ou
    // rows, _ := db.Query("select id, nome from usuarios where id > ?", 5)
    defer rows.Close()

    for rows.Next(){

        var u usuario
        rows.Scan(&u.id, &u.nome)
        fmt.PrintLn(u)
    }
    
}


================= HTTP ================= 

package main

func main(){

    fs := http:FileServer(http.Dir("public"))
    http.Handle("/", fs)

    log.PrintLn("Executando ...")
    log.Fatal(http.ListenAndServe(":3000", nil))
}

no navegador acessar 
localhost:3000

--- HTTP conteudo dinamico

package main

func horaCerta(w http.ResopnseWriter, r *http.Request){

    s:= time.now().Format("02/01/2006 03:04:05")
    fmt.Fprintf(w, "<h1> Hora certa : %s</h1>", s)
}

func main(){

    http.HandleFunc("/horaCerta", horaCerta)
    log.PrintLn("Executando ....")
    log.Fatal(http.ListenAndServe(:3000, nil))
}


================= HTTP + DB ================= 

package main

type Usuario struct {
    ID int `json:"id"` 
    Nome string `json:"nome"`
}

func UsuarioHandler(w http.ResponseWriter, r *http.Request) {

    sid := strings.TrimPrefix(r.URL.Path, "/usuarios/")
    id, _ := strconv.Atoi(sid)

    switch {
    case r.Method == "GET" && id > 0:
        usuarioPorID(w, r, id)
    case r.Method == "GET":
        usuarioTodos(w, r)
    default:
        w.WriteHeader(http.StatusNotFound)
        fmt.Fprintf(w, "Desculpa... :( ")
    }
}

func usuarioPorID(w http.ResponseWriter, r *http.Request, id int){

    db, err := sql.Open("mysql", "root:123456@/cursogo")
    if err != nil {
        log.Fatal(err)
    }
    defer db.Close()

    var c := Usuariodb.QueryRow("select id, nome from usuarios where id = ?", id).Scan(&u.ID, &u.Nome)

    json, _ := json.Marshal(u)

    w.Header().set("Context-type", "application/json")
    fmt.Fprintf(w, string(json))
} 

func usuarioTodos(w http.ResponseWriter, r *http.Request){

    db, err := sql.Open("mysql", "root:123456@/cursogo")
    if err != nil {
        log.fatal(err)
    }
    defer db.Close()

    rows, _ := Usuariodb.Query("select id, nome from usuarios")
    defer rows.Close()

    var usuarios []Usuario
    for rows.Next(){

        var usuario Usuario
        rows.Scan(&usuario.ID, &usuario.Nome)
        usuarios = append(usuarios, usuario)
    }

    json, _ := json.Marshal(usuarios)

    w.Header().set("Context-type", "application/json")
    fmt.Fprintf(w, string(json))
} 

func main(){

    http.HandleFunc("/usuarios/", UsuarioHandler)
    log.PrintLn("Executando ...")
    log.Fatal(http.ListenAndServe(":3000", nil))
}

Executar mais de um arquivo .go
go run *.go






go mod tidy -> linpa bibliotecas 
go mod vendor -> baixa as bibliotecas 

Prometheus
porta padr??o prometheus
http://localhost:9090/metrics

go get github.com/prometheus/client_golang/prometheus
go get github.com/prometheus/client_golang/prometheus/promauto
go get github.com/prometheus/client_golang/prometheus/promhttp

"github.com/labstack/echo/v4"
"github.com/prometheus/client_golang/prometheus/promhttp"

func main() {
    http.Handle("/metrics", promhttp.Handler())
    http.ListenAndServe(":2112", nil)
}

MAP
REDUCE
FIILTER 




