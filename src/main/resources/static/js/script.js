function showAlert()
{
    console.log("Duplicate");
    alert("A person with this ID already exists.");
}

function deleteClick(button)
{
    const row = button.closest('td');
    const confirmationDiv = row.querySelector('div');
    const deleteButton = row.querySelector('.delete');
    confirmationDiv.style.display = '';
    deleteButton.style.display = 'none';
}

function noClick(button)
{
    const row = button.closest('td');
    const deleteButton = row.querySelector('.delete');
    const confirmationDiv = row.querySelector('div');
    confirmationDiv.style.display = 'none';
    deleteButton.style.display = '';
}
