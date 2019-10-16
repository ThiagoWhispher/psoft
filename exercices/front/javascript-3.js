let proto_pessoa = {
    fale: function () {
        return "oi, eu sou " + this.nome;
    }
};

function create_pessoa(nome) {
    let pessoa = Object.create(proto_pessoa);
    pessoa.nome = nome;
    return pessoa;
}

let p1 = create_pessoa('Thiago');
let p2 = create_pessoa('Igor');
let p3 = create_pessoa('Gabriela');

console.log(p1.fale());
console.log(p2.fale());
console.log(p3.fale());
