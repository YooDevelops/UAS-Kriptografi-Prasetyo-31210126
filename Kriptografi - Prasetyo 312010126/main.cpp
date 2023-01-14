#include <iostream>
#include <string>

using namespace std;

void cipherDecryption()
{
    cout << "Enter message: ";
    string msg;
    cin >> msg;

    cout << "Enter key: ";
    string key;
    cin >> key;

    string hexToDeci = "";
    for (int i = 0; i < msg.length() - 1; i += 2)
    {
        // splitting hex into a pair of two
        string output = msg.substr(i, (i + 2));
        int decimal = stoi(output, nullptr, 16);
        hexToDeci += (char)decimal;
    }

    // decryption
    string decrypText = "";
    int keyItr = 0;
    for (int i = 0; i < hexToDeci.length(); i++)
    {
        // XOR Operation
        int temp = hexToDeci[i] ^ key[keyItr];

        decrypText += (char)temp;
        keyItr++;
        if (keyItr >= key.length())
        {
            // once all of key's letters are used, repeat the key
            keyItr = 0;
        }
    }

    cout << "Decrypted Text: " << decrypText << endl;
}

void cipherEncryption()
{
    cout << "Enter message: ";
    string msg;
    cin >> msg;

    cout << "Enter key: ";
    string key;
    cin >> key;

    string encrypHexa = "";
    int keyItr = 0;
    for (int i = 0; i < msg.length(); i++)
    {
        // XOR Operation
        int temp = msg[i] ^ key[keyItr];

        char buf[3];
        snprintf(buf, sizeof(buf), "%02x", temp);
        encrypHexa += buf;
        keyItr++;
        if (keyItr >= key.length())
        {
            // once all of key's letters are used, repeat the key
            keyItr = 0;
        }
    }

    cout << "Encrypted Text: " << encrypHexa << endl;
}

int main()
{
    cout << "1. Encryption\n2. Decryption\nChoose(1,2): ";
    int choice;
    cin >> choice;

    if (choice == 1)
    {
        cout << "---Encryption---" << endl;
        cipherEncryption();
    }
    else if (choice == 2)
    {
        cout << "---Decryption---" << endl;
        cipherDecryption();
    }
    else
    {
        cout << "Invalid Choice" << endl;
    }
    return 0;
}
