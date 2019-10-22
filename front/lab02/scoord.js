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
  p.set_nome = (newnome) => nome = newnome;
  p.email = email;
  p.cpf = cpf;
  p.url_foto = url_foto;
  p.turmas_alocadas = [];
  p.aloca_turma = (t) => p.turmas_alocadas.push(t);
  p.turmas = (semestre) => p.turmas_alocadas.filter((turma) => turma.semestre() === semestre);
  return p;
}

exports.estudante = function estudante(matricula, nome, email, cpf, url_foto){
  let e = Object.create(Object.prototype);
  e.matricula = () => matricula;
  e.get_nome = () => nome;
  e.set_nome = (newnome) => nome = newnome;
  e.email = email;
  e.cpf = cpf;
  e.url_foto = url_foto;
  e.turmas_alocadas = [];
  e.aloca_turma = (t) => e.turmas_alocadas.push(t);
  e.turmas = (semestre) => e.turmas_alocadas.filter((turma) => turma.semestre() === semestre);
  return e;
}

exports.turma = function turma(disciplina, semestre){
  let _status = 'planejada';
  let t = Object.create(Object.prototype);
  let professor = null;
  let estudantes = [];
  let _semestre = semestre;
  t.disciplina = () => disciplina;
  t.semestre = () => _semestre;
  t.set_professor = (newprofessor) => professor = newprofessor;
  t.get_professor = () => professor;
  t.get_estudantes = () => estudantes;
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
    if(!estudantes.includes(estudante) && accepted_status.includes(_status)){
      estudantes.push(estudante);
    }
  };
  t.desmatricula = function(estudante){
    accepted_status = ['planejada', 'ativa'];
    if(estudantes.includes(estudante) && accepted_status.includes(_status)){
      estudantes.splice(estudantes.indexOf(estudante), 1);
    }
  }
  return t;
}
