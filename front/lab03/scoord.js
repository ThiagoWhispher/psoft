exports.disciplina = class Disciplina{
  constructor(id, nome, creditos, pre_requisitos){
    this._id = id;
    this._nome = nome;
    this.creditos = creditos;
    this.pre_requisitos = pre_requisitos;
  }

  id(){
    return this._id;
  }

  get_nome(){
    return this._nome;
  }

  set_nome(newnome){
    this._nome = newnome;
  }
}

function Pessoa(matricula, nome, email, cpf, url_foto){
  this.matricula = () => matricula;
  this.get_nome = () => nome;
  this.set_nome = (newnome) => nome = newnome;
  this.email = email;
  this.cpf = cpf;
  this.url_foto = url_foto;
  this.turmas_alocadas = [];
  this.aloca_turma = (t) => this.turmas_alocadas.push(t);
  this.turmas = (semestre) => this.turmas_alocadas.filter((turma) => turma.semestre() === semestre);
}

exports.professor = function Professor(matricula, nome, email, cpf, url_foto){
  Pessoa.call(this, matricula, nome, email, cpf, url_foto);
}

exports.estudante = function Estudante(matricula, nome, email, cpf, url_foto){
  Pessoa.call(this, matricula, nome, email, cpf, url_foto);
}

exports.turma = class Turma{
  constructor(disciplina, semestre){
    this._disciplina = disciplina;
    this._semestre = semestre;
    this._professor = null;
    this._estudantes = [];
    this._status = 'planejada';
  }

  disciplina(){
    return this._disciplina;
  }

  semestre(){
    return this._semestre;
  }

  set_professor(newprofessor){
    this._professor = newprofessor;
  }

  get_professor(){
    return this._professor;
  }

  get_estudantes(){
    return this._estudantes;
  }

  get_status(){
    return this._status;
  }

  set_status(newstatus){
    let accepted_status = ['planejada', 'ativa', 'concluida'];
    if(accepted_status.includes(newstatus)){
      this._status = newstatus;
    }
  }

  matricula(estudante){
    let accepted_status = ['planejada', 'ativa'];
    if(!this._estudantes.includes(estudante) && accepted_status.includes(this._status)){
      this._estudantes.push(estudante);
    }
  }

  desmatricula(estudante){
    let accepted_status = ['planejada', 'ativa'];
    if(this._estudantes.includes(estudante) && accepted_status.includes(this._status)){
      this._estudantes.splice(this._estudantes.indexOf(estudante), 1);
    }
  }
}
