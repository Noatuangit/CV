export default function validationCustom(dataForm) {
    let isValid = true;
    let valid = {}
    const currentYear = new Date().getFullYear();
    if (dataForm.title.trim() == "") {
        valid.requiredTitle = true;
        isValid = false;
    }
    if (dataForm.category == undefined) {
        valid.requiredCategory = true
        isValid = false;
    }
    if (dataForm.author.trim() == "") {
        valid.requiredAuthor = true
        isValid = false;
    } else if ((dataForm.author).match(/[0-9]/)) {
        valid.patternAuthor = true;
        isValid = false;
    }
    if (dataForm.year.trim() == "") {
        valid.requiredYear = true
        isValid = false;
    } else if (!/^[0-9]+$/.test(dataForm.year)) {
        valid.patternYear = true;
        isValid = false;
    } else if (+dataForm.year > currentYear) {
        valid.maxYear = true;
        isValid = false;
    }
    return [valid, isValid];
}