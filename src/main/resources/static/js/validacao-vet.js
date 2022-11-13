//campos validação
const dataDeNascimento = document.getElementById('dataDeNascimento');
const telefoneVet = document.getElementById('telefoneVet'); 


function validacao_vet(item){
    item.setCustomValidity('');
    item.checkValidity();


    if(item == dataDeNascimento){
        let hoje = new Date(); //data atual
        let dnasc = new Date(dataDeNascimento.value);

        let idadeVet = hoje.getFullYear() - dnasc.getFullYear();
        let mes = hoje.getMonth() - dnasc.getMonth();

        if (mes < 0 || (mes === 0 && hoje.getDate() < dnasc.getDate())){
            idadeVet--;
        }

        if(idadeVet >= 0) document.getElementById('idadeVet').value = idadeVet + ' anos ';
        else document.getElementById('idadeVet').value = "Ainda não nascido";

        if(idadeVet > 100) item.setCustomValidity('Há algo errado com sua idade.');
        else if(idadeVet >= 18) item.setCustomValidity('');
        else item.setCustomValidity('Você precisa ser maior de 18 anos');

    }

    

}

function maskTel() {
    let strtel = telefoneVet.value;
    if( strtel.length == 2){
        telefoneVet.value +=") ";
        telefoneVet.value = "(" + telefoneVet.value;
    }
    if (strtel.length == 10) telefoneVet.value += "-";
}



//validação a cada alteração de entrada
dataDeNascimento.addEventListener('input', function () { validacao_vet(dataDeNascimento) });
telefoneVet.addEventListener('input', function () { maskTel() });
