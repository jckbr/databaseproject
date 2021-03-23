# databaseproject
#### Kaylee Moore and Jack Lindner

This CS 461 Final Project is our Game Rental Database system. The database has five tables linked together using keys,
as well as a GUI to display and modify, delete, or add entries.

To run this database program, simply run the DatabaseUI.java file. This will output whether the connection to the
database was successful, then displaying a GUI with entries and buttons.

The GUI will display the Games table by default.

The 'New Transaction' button will allow you to input the information
for a new transaction. The given dropdown prompts will show the available options for keys, as all information
needs to be compatible with other tables.

The 'Delete' button will display a popup box depending on the currently displayed table asking for the primary key
of the item you are looking to delete. Entering the correct information will delete that entry in the table.

The 'Update' button will display a series of popups, which will gather the information for a new entry to the currently
displayed table.

The 'Next' and 'Previous' buttons will cycle between the available tables.

The dropdown box will allow you to pick a table directly, without needing to cycle through.

The search textbox will filter the current displayed table, and only show the entries that match the entered
information. You will need to press 'Enter' after your search query.

Below the buttons, the currently displayed table will show all entries for the database table in question.
