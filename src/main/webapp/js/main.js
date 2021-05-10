function sendFormMenu(section) {
    let input = document.createElement('input');

    input.name = 'section';
    input.type = 'hidden';
    input.value = section;

    formMenu.append(input);
    formMenu.submit();
}