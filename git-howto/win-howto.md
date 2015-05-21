Git on Windows
=======

This is the instruction for a git installation (using tortoisegit client) on a windows machine.
 
Required
--------

You will need to download the latest git release from https://git-scm.com and a git client. My client of choise is tortoise git (https://code.google.com/p/tortoisegit) but there are others like sourcetree that look cooler :)

Git and Git-Client installation
------------

If you want to use tortoise git follow the install instructions here: https://code.google.com/p/tortoisegit/wiki/SetupHowTo

For this i assume you check "Use Putty ..." in the tortoise git installation process.

For other clients or command line usage you have to look for yourself. 

SSH Key and Putty
-----------------

Okay, if you have everything installed, we first configure the environment. You have installed the git release, and with it the GIT Bash. Goto Start->Programs->Git->Git Bash and open it.

(See http://git-scm.com/book/en/Getting-Started-First-Time-Git-Setup for details)

You will see a command line window, don't be afraid. For some useful commans see the cheat sheets: 

Enter the following two lines, to configure the global name and email adress used by git:

> $ git config --global user.name "Your Name"
> $ git config --global user.email your_mail@example.com

Here you put your name and email address from github!

Then, we will have to create a new directory for SSH. Because in windows you cannot create a directory with a dot at the beginning (we need a .ssh directory), we use the Git Bash for it. First make sure you are in your home folder, if so you will have a ~ (tilde) next to your username@pcname. Else just enter:

> $ cd ~

After that create the directory by entering:

> $ mkdir .ssh

Okay, after that you can close the Git Bash window. With tortoise git you will have Puttygen installed, Start->Programs->Putty->Puttygen.

* Open it and check if it has "SSH-2 RSA" checked, and set the number of generated bits to 4096 or higher. Click the "Generate" button and wait/move the mouse to gernerate some randomness. 

* After that enter your previous set mail in the "Key comment" field and feel free to choose a passphrase. 

* Save the private key in the previously created .ssh directory - name it sth like "Github-Desktop.ppk" - and export it as OpenSSH - name this sth like "github_id_rsa" without any extension! 

* In Puttygen you also have a window with the OpenSSH public key. In the .ssh directory create a new file - name it like the previous, but with extension .pub - and paste the whole window content.

In the end you will have 3 files:

* one Github-Desktop.ppk
* one github_id_rsa
* and one github_id_rsa.pub

Now go to https://github.com/settings/ssh and click "Add SSH Key", name it sth like "Desktop" and also paste the content from the Puttygen window (or github_id_rsa.pub) here. Click "Add Key" and you are done.

Okay, that done we are ready to clone the repository.

Clone the Repo
--------------

There are several ways to set your ssh key for tortoise git. One is to use Putty (https://code.google.com/p/tortoisegit/wiki/UsingPuTTY). 

The other is to define it inside the TortoiseGit and make it deal with putty directly. This option is available if you installes tortoisegit with putty correctly. You can verify this if you try to clone a repository (Right Click into a folder, then 'Git Clone...'), the option 'Load Putty Key' is enabled. Here you point to the ppk file in your .ssh directory.

Got to a place on your pc where your projects or software is stored, right click and choose the "Clone" option from the TortoiseGit-Explorer Context Menu as before. You will have to enter the URL of the repo, e.g.:

> git@github.com:gormed/tutorium.git

You will see that below the line will automatically create the sub-directory, which you can change to another name, it is important that it is empty. Click okay, and wait until it is done :)
