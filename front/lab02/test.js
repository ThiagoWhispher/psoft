let assert = require('assert');
let disciplina = require('./scoord').disciplina;
let professor = require('./scoord').professor;
let estudante = require('./scoord').estudante;
let turma = require('./scoord').turma;

describe('factory Disciplina', function() {
  let d0;

    before(async () => {
        d0 = disciplina('prog1', 'Programação 1', 4, []);
    })

    it('deve criar disciplinas distintas a cada invocação', function(){
        d0 = disciplina('prog1', 'Programação 1', 4, []);
        d1 = disciplina('prog1', 'Programação 1', 4, []);
        d2 = disciplina('prog1', 'Programação 1', 4, []);
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it('deve reter os dados de inicialização', function(){
        assert.equal('prog1', d0.id());
        assert.equal('Programação 1', d0.get_nome());
        assert.equal(4, d0.creditos);
        assert.deepEqual([], d0.pre_requisitos);
    });

    it('deve permitir atualização de nome', function(){
        d0.set_nome('Programação de Computadores I')
        assert.equal('prog1', d0.id());
        assert.equal('Programação de Computadores I', d0.get_nome());
        assert.deepEqual([], d0.pre_requisitos);
    });

    it('nÃ£o deve permitir atualização de id via set_id', function(){
        assert.throws(function () {
            d0.set_id('outro')
        }, TypeError);
        assert.equal('prog1', d0.id());
    });

});

describe('factory Professor', function() {
  let d0;

    before(async () => {
        d0 = professor('1', 'Professor 1', 'professor1@gmail.com', '1111111-1', 'www.image.com/professor1.png');
    })

    it('deve criar professores distintos a cada invocação', function(){
        d0 = professor('1', 'Professor 1', 'professor1@gmail.com', '1111111-1', 'www.image.com/professor1.png');
        d1 = professor('1', 'Professor 1', 'professor1@gmail.com', '1111111-1', 'www.image.com/professor1.png');
        d2 = professor('1', 'Professor 1', 'professor1@gmail.com', '1111111-1', 'www.image.com/professor1.png');
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it('deve reter os dados de inicialização', function(){
        assert.equal('1', d0.matricula());
        assert.equal('Professor 1', d0.get_nome());
        assert.equal('professor1@gmail.com', d0.email);
	assert.equal('1111111-1', d0.cpf);
	assert.equal('www.image.com/professor1.png', d0.url_foto);
    });

    it('deve permitir atualizações', function(){
        d0.set_nome('Professor 2')
        assert.equal('Professor 2', d0.get_nome());
        assert.deepEqual([], d0.turmas_alocadas);
	t0 = turma(disciplina('ic', 'Introdução a computação', 4, []), '20172')
	d0.aloca_turma(t0);
	assert.deepEqual([t0], d0.turmas_alocadas);
	assert.deepEqual([t0], d0.turmas('20172'));
    });

    it('nÃ£o deve permitir atualização de matricula via set_matricula', function(){
        assert.throws(function () {
            d0.set_matricula('222')
        }, TypeError);
        assert.equal('1', d0.matricula());
    });
});

describe('factory Estudante', function() {
  let d0;

    before(async () => {
        d0 = estudante('1', 'Estudante 1', 'estudante1@gmail.com', '1111111-1', 'www.image.com/estudante1.png');
    })

    it('deve criar estudantes distintos a cada invocaÃ§Ã£o', function(){
        d0 = estudante('1', 'Estudante 1', 'estudante1@gmail.com', '1111111-1', 'www.image.com/estudante1.png');
        d1 = estudante('1', 'Estudante 1', 'estudante1@gmail.com', '1111111-1', 'www.image.com/estudante1.png');
        d2 = estudante('1', 'Estudante 1', 'estudante1@gmail.com', '1111111-1', 'www.image.com/estudante1.png');
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it('deve reter os dados de inicialização', function(){
        assert.equal('1', d0.matricula());
        assert.equal('Estudante 1', d0.get_nome());
        assert.equal('estudante1@gmail.com', d0.email);
        assert.equal('1111111-1', d0.cpf);
        assert.equal('www.image.com/estudante1.png', d0.url_foto);
    });

    it('deve permitir atualizações', function(){
        d0.set_nome('Estudante 2')
        assert.equal('Estudante 2', d0.get_nome());
        assert.deepEqual([], d0.turmas_alocadas);
        t0 = turma(disciplina('ic', 'Introdução a computação', 4, []), '20172')
        d0.aloca_turma(t0);
        assert.deepEqual([t0], d0.turmas_alocadas);
        assert.deepEqual([t0], d0.turmas('20172'));
    });

    it('nÃ£o deve permitir atualização de matricula via set_matricula', function(){
        assert.throws(function () {
            d0.set_matricula('222')
        }, TypeError);
        assert.equal('1', d0.matricula());
    });
});

describe('factory Turma', function() {
  let d0;

    before(async () => {
        d0 = turma(disciplina('ic', 'Introdução a computação', 4, []), '20172');
    })

    it('deve criar turmas distintas a cada invocação', function(){
        d0 = turma(disciplina('ic', 'Introdução a computação', 4, []), '20172');
        d1 = turma(disciplina('lprog1', 'Laboratório de programação 1', 4, []), '20172');
        d2 = turma(disciplina('prog1', 'Programação 1', 4, []), '20172');
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it('deve reter os dados de inicialização', function(){
        assert.equal('planejada', d0.status);
        assert.equal('20172', d0.semestre());
        assert.equal(null, d0.get_professor());
        assert.deepEqual([], d0.get_estudantes());
	assert.equal(d0.disciplina().id(), 'ic');
    });

    it('deve permitir atualizações', function(){
        d0.status = 'asdadasdas';
        assert.equal('planejada', d0.status);
        d0.status = 'ativa';
	assert.equal('ativa', d0.status);
	assert.deepEqual([], d0.get_estudantes());
	e0 = estudante('1', 'Estudante 1', 'estudante1@gmail.com', '1111111-1', 'www.image.com/estudante1.png');
	e1 = estudante('2', 'Estudante 2', 'estudante2@gmail.com', '2222222-2', 'www.image.com/estudante2.png')
	d0.matricula(e0);
	d0.matricula(e0);
	assert.deepEqual([e0], d0.get_estudantes());

	d0.desmatricula(e1);
	assert.deepEqual([e0], d0.get_estudantes());
        d0.desmatricula(e0);
	assert.deepEqual([], d0.get_estudantes());

	p0 = professor('1', 'Professor 1', 'professor1@gmail.com', '1111111-1', 'www.image.com/professor1.png');
        assert.equal(null, d0.get_professor());
        d0.set_professor(p0);
	assert.equal(p0, d0.get_professor());
    });
});
