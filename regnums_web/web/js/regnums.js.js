var number_element_inx = 1;

function onSelectRegisterType(e){
    var sIndex = e.target.selectedIndex;
    var sValue = e.target.options[sIndex].value;
    if(sValue == 1){
        //Делаем видимым поле для ввода постоянного значения
        document.getElementById('td_constvalue1').style.display = 'block';
    }
}

function addGeneratorElement(){
    var tbl = document.getElementById("reg_table");
    number_element_inx++;
    if(number_element_inx <= 5){
        if(tbl != null){                
            var new_tr = '<tr><td>Тип генератора</td>'+
                '<td><select name="gentype'+number_element_inx+'" onchange="onSelectRegisterType(event)">'+
                '<option value="-1" title="Укажите тип генератора">Укажите тип генератора</option>'+
                '</select></td></tr>';
            tbl.innerHTML += new_tr;
        }
    }else{
        document.getElementById("divMsg").innerHTML = 'Для номера можно добавлять не более 5 элементов.';
    }
    
}