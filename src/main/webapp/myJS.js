function getCountryCode() {
    var countryName = document.getElementById('countryName').value;
    makeRequest('getCountryCode', countryName, 'countryCodeResult');
}

function getCountryName() {
    var countryCode = document.getElementById('countryCode').value;
    makeRequest('getCountryName', countryCode, 'countryNameResult');
}

function getCountryDetails() {
    var countryInfoCode = document.getElementById('countryInfoCode').value;
    makeRequest('getCountryDetails', countryInfoCode, 'countryDetailsResult');
}

function convertNumberToWords() {
    var number = document.getElementById('number').value;
    makeRequest('convertNumber', number, 'numberToWordsResult');
}

function makeRequest(action, value, resultElementId) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'NC_convertor_servlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById(resultElementId).innerHTML = xhr.responseText;
        }
    };
    xhr.send('action=' + action + '&value=' + encodeURIComponent(value));
}
