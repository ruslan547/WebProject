function sendFormMenu(section) {
    let input = document.createElement('input');
    input.name = 'section';
    input.type = 'hidden';
    input.value = section;

    formMenu.append(input);
    formMenu.submit();
}

function sendDeleteForm() {
    deleteForm.submit();
}

function addProgram() {
    let program = program_cont.cloneNode(true);
    let childes = program.childNodes;
    let input_checked = document.createElement('input');
    input_checked.type = 'checkbox';
    input_checked.name = 'flag_remove';



    for (let i = 0; i < childes.length; i++) {
        let node = childes.item(i);
        if(node.nodeName == 'input') {
            node.nodeValue = '';
        }
    }

    program.id = '';
    program.append(input_checked);
    add_btn.before(program);
}

function removeProgram() {
    let checkboxNodes = document.getElementsByName('flag_remove');

    for (let i = checkboxNodes.length - 1; i >= 0; i--) {
        let node = checkboxNodes.item(i);
        if(node.checked) {
            node.parentNode.remove();
        }
    }

}