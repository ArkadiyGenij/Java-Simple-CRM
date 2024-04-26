function hideMessages() {
    if (window.location.href.includes('logout=true')) {
        document.getElementById('logoutAlert').style.display = 'none';
    } else {
        document.getElementById('errorAlert').style.display = 'none';
    }
}

function onBack(){
    window.history.back();
}