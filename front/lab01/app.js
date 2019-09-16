console.log('app rodando!');

const URL = 'https://lab01-projsw-ufcg.herokuapp.com/api/';

let $disciplinas = document.querySelector("div");
let $button = document.querySelector("#newdisciplina");
let $nome = document.querySelector("#nome");
let $nota = document.querySelector("#nota");

function save_disciplina(){
  let nome = $nome.value;
  let nota = $nota.value;
  fetch(URL + "disciplinas", {
    'method' : 'POST',
    'body': `{"nome" : "${nome}", "nota" : ${nota}}`,
    'headers' : {'Content-Type' : 'application/json'}
  })
  .then(response => response.json())
  .then(dado => {
    let $p = document.createElement("p");
    $p.innerText = `Nome: ${nome}. Nota: ${nota}`;
    $disciplinas.appendChild($p);
  });
}

function delete_disciplina(id){
  fetch(URL + "disciplinas/" + id, {
    'method' : 'DELETE',
    'headers' : {'Content-Type' : 'application/json'}
  })
}

function fetch_disciplinas(){
  fetch(URL + "disciplinas")
  .then(response => response.json())
  .then(dados => {
    dados.forEach(dado => {
      let $p = document.createElement("p");
      $p.innerText = `Nome: ${dado.nome}. Nota: ${dado.nota}`;
      $disciplinas.appendChild($p);
      let $newbutton = document.createElement("button");
      $newbutton.innerText = 'Deletar disciplina';
      $newbutton.addEventListener('click', _ => {
        delete_disciplina(dado.id);
      });
      $p.appendChild($newbutton);
    });
  });
}

fetch_disciplinas();
$button.addEventListener('click', save_disciplina);
