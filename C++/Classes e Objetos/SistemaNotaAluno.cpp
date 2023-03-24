#include <iostream>
#include <windows.h>
#include <string>

using namespace std;

class Aluno
{
    public:
        string getNome();
        float getNotaFinal();
        int getFaltas();
        bool setNome(string nome),
             setNotaFinal(float notaFinal),
             setFaltas(int faltas);
        bool verificarNota(),
             verificarFaltas();
    private:
        string nome;
        float notaFinal;
        int faltas;
};

string Aluno::getNome()
{
    return nome;
}

float Aluno::getNotaFinal()
{
    return notaFinal;
}
int Aluno::getFaltas()
{
    return faltas;
}

bool Aluno::setNome(string nome)
{
    for(int i = 0; i < nome.size(); i++)
    {
        for (int j = 33; j <= 64; j++)
        {
            if(nome[i] == j)
            {
                cout << "\nErro: Este nome possui caractere(s) inválido(s)!" << endl;
                return false;
            }
        }
    }
    this->nome = nome;
    return true;
}

bool Aluno::setNotaFinal(float notaFinal)
{
    if(notaFinal < 0)
    {   
        cout << "\nErro: Nota inválida!" << endl;
        return false;
    }
    this->notaFinal = notaFinal;
    return true;
}

bool Aluno::setFaltas(int faltas)
{
    if(faltas < 0)
    {
        cout << "\nErro: Número de faltas inválido!" << endl;
        return false;
    }
    this->faltas = faltas;
    return true;
}

bool Aluno::verificarNota()
{
    return (getNotaFinal() >= 60);
}

bool Aluno::verificarFaltas()
{
    return (getFaltas() <= 25);
}

int main()
{
    SetConsoleOutputCP(CP_UTF8);
    Aluno aluno;

    string nome;
    SolicitacaoNome:
    cout << " Digite o nome do aluno: ";
    getline(cin, nome);
    bool nomeOk = aluno.setNome(nome);
    if(!nomeOk)
    {
        cout << "\n\nPressione ENTER para inserir novamente...";
        setbuf(stdin, NULL);
        getchar();
        system("cls");
        goto SolicitacaoNome;
    }
    
    float nota;
    SolicitacaoNota:
    cout << " Digite a nota do aluno: ";
    cin >> nota;
    bool notaOk = aluno.setNotaFinal(nota);
    if(!notaOk)
    {
        cout << "\n\nPressione ENTER para inserir novamente...";
        setbuf(stdin, NULL);
        getchar();
        system("cls");
        goto SolicitacaoNota;
    }

    int faltas;
    SolicitacaoFaltas:
    cout << " Digite o nº de faltas do aluno: ";
    cin >> faltas;
    bool faltasOk = aluno.setFaltas(faltas);
    if(!faltasOk)
    {
        cout << "\n\nPressione ENTER para inserir novamente...";
        setbuf(stdin, NULL);
        getchar();
        system("cls");
        goto SolicitacaoFaltas;
    }

    if(aluno.verificarNota() && aluno.verificarFaltas())
        cout << endl << aluno.getNome() << " está aprovado.\n" << endl;
    if(!aluno.verificarNota() && aluno.verificarFaltas())
        cout << endl << aluno.getNome() << " está reprovado, pois não atingiu os 60 pontos.\n" << endl;
    if(aluno.verificarNota() && !aluno.verificarFaltas())
        cout << endl << aluno.getNome() << " está reprovado, pois possui mais de 25 faltas.\n" << endl;
    if(!aluno.verificarNota() && !aluno.verificarFaltas())
        cout << endl << aluno.getNome() << " está reprovado, pois não atingiu os 60 pontos e possui mais de 25 faltas.\n" << endl;
    
    return 0;
}