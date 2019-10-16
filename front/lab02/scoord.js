exports.disciplina = function disciplina(id, nome, creditos, pre_requisitos){
  let d = Object.create(Object.prototype);
  d.id = () => id;
  d.get_nome = () => nome;
  d.set_nome = (newnome) => nome = newnome;
  d.creditos = creditos;
  d.pre_requisitos = pre_requisitos;
  return d;
}

exports.professor = function professor(matricula, nome, email, cpf, url_foto){
  let p = Object.create(Object.prototype);
  p.matricula = () => matricula;
  p.get_nome = () => nome;
  p.email = email;
  p.cpf = cpf;
  p.url_foto = url_foto;
  p.turmas = [];
  p.aloca_turma = (t) => turmas.push(t);
  p.turmas = (semestre) => turmas.filter((turma) => turma.periodo === semestre);
  return p;
}

exports.estudante = function estudante(matricula, nome, email, cpf, url_foto){
  let e = Object.create(Object.prototype);
  e.matricula = () => matricula;
  e.get_nome = () => nome;
  e.email = email;
  e.cpf = cpf;
  e.url_foto = url_foto;
  e.turmas = [];
  e.aloca_turma = (t) => turmas.push(t);
  e.turmas = (semestre) => turmas.filter((turma) => turma.semestre === semestre);
  return e;
}

exports.turma = function turma(disciplina, semestre){
  let _status = 'planejada';
  let t = Object.create(Object.prototype);
  t.professor = null;
  t.estudantes = [];
  Object.defineProperty(t, 'status', {
    get: () => _status,
    set: function (new_status){
      accepted_status = ['planejada', 'ativa', 'concluida'];
      if(accepted_status.includes(new_status)){
        _status = new_status;
      }
    }
  });
  t.matricula = function(estudante){
    accepted_status = ['planejada', 'ativa'];
    if(!t.estudantes.includes(estudante) && accepted_status.inclues(_status)){
      t.estudantes.push(estudante);
    }
  };
  //TODO falta desmatricula
  return t;
}
