function create_turma(disciplina, vagas){
  let turma = {};
  turma.quantVagas = vagas;
  turma.disciplina = disciplina;
  turma.alunosNaTurma = [];
  turma.matricule = function (aluno) {
    if (turma.vagas() > 0){
      turma.alunosNaTurma.push(aluno);
      return true;
    }else{
      return false;
    }
  }
  turma.alunos = function () { return turma.alunosNaTurma; }
  turma.vagas = function () { return turma.quantVagas - turma.alunosNaTurma.length; }
  return turma;
}

turma1 = create_turma('psoft', 3);
turma2 = create_turma('bd1', 5);

console.log("-------------- TURMA 1 ----------------")
console.log("Quantidade de vagas -- " + turma1.vagas());
console.log("Cadastrando Thiago na turma 1 -- " + turma1.matricule('Thiago'));
console.log("Quantidade de vagas -- " + turma1.vagas());
console.log("Cadastrando Igor na turma 1 -- " + turma1.matricule('Igor'));
console.log("Quantidade de vagas -- " + turma1.vagas());
console.log("Cadastrando Gabriela na turma 1 -- " + turma1.matricule('Gabriela'));
console.log("Quantidade de vagas -- " + turma1.vagas());
console.log("Alunos matriculados na turma 1 -- " + turma1.alunos());

console.log("-------------- TURMA 2 ----------------");
console.log("Quantidade de vagas -- " + turma2.vagas());
console.log("Cadastrando Thiago na turma 2 -- " + turma2.matricule('Thiago'));
console.log("Quantidade de vagas -- " + turma2.vagas());
console.log("Cadastrando Igor na turma 2 -- " + turma2.matricule('Igor'));
console.log("Quantidade de vagas -- " + turma2.vagas());
console.log("Cadastrando Gabriela na turma 2 -- " + turma2.matricule('Gabriela'));
console.log("Quantidade de vagas -- " + turma2.vagas());
console.log("Alunos matriculados na turma 2 -- " + turma2.alunos());
