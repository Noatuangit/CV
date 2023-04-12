export default function validationCustom(dataForm) {
    let isValid = true;
    let valid = {}
    const currentYear = new Date().getFullYear();

    if (dataForm.status == '') {
        valid.requiredStatus = true
        isValid = false;
    }
    if ((dataForm.username + "").trim() == "") {
        valid.requiredUsername = true
        isValid = false;
    } else if ((dataForm.username + "").match(/[0-9]/)) {
        valid.patternUsername = true;
        isValid = false;
    }
    if ((dataForm.email + "").trim() == "") {
        valid.requiredEmail = true
        isValid = false;
    } else if (!/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(dataForm.email)) {
        valid.patternEmail = true;
        isValid = false;
    }

    return [valid, isValid];
}
