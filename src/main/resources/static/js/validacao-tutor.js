//campos validação
const dataNascimento = document.getElementById('dataNascimento');
const telefone = document.getElementById('telefone'); 


function validacao_tutor(item){
    item.setCustomValidity('');
    item.checkValidity();



    if(item == dataNascimento){
        let hoje = new Date(); //data atual
        let dnascimento = new Date(dataNascimento.value);

        let idade = hoje.getFullYear() - dnascimento.getFullYear();
        let mes = hoje.getMonth() - dnascimento.getMonth();

        if (mes < 0 || (mes === 0 && hoje.getDate() < dnascimento.getDate())){
            idade--;
        }

        if(idade >= 0) document.getElementById('idade').value = idade + ' anos ';
        else document.getElementById('idade').value = "Ainda não nascido";

        if(idade > 100) item.setCustomValidity('Há algo errado com sua idade.');
        else if(idade >= 18) item.setCustomValidity('');
        else item.setCustomValidity('Você precisa ser maior de 18 anos');

    }

    

}

function maskTelefone() {
    let tel = telefone.value;
    if( tel.length == 2){
        telefone.value +=") ";
        telefone.value = "(" + telefone.value;
    }
    if (tel.length == 10) telefone.value += "-";
}



//validação a cada alteração de entrada
dataNascimento.addEventListener('input', function () { validacao_tutor(dataNascimento) });
telefone.addEventListener('input', function () { maskTelefone() });
