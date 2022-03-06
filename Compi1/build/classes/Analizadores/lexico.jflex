package Analizadores;
import java_cup.runtime.Symbol; 
import Estructuras.*;
%% 
%class Lexico
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 

ESPACIOS = [ \r\t]+
DIGITO= [0-9]+
LETRA = [a-z]|[A-Z]
CARACTER = [ -}]
CHAREX = [\"][^\"][\"]
ESPECIALES = ("\\n"|"\\""\'"|"\\""\"")
CADENA = [\"]([^\"\n]|(\\\"))*[\"]
IDENTIFICADOR=[a-zA-Z]+["_"a-z0-9A-Z]*      
RANGO1 = [0-9]+"~"[0-9]+
RANGO2 = [A-Z]" "*"~"" "*[A-Z]
RANGO3 = [a-z]" "*"~"" "*[a-z]
RANGO4 = [ -}]" "*"~"" "*[ -}]
COMENTARIO = ("//".*)|("//".*\n)
COMENTARIOMULTI = "<!""!"*([^!>])*"!"*"!>"

%{
    public void addError(MiError error)
    {
        compi1.interfaz.errores.add(error);
    }
%}

%%

{ESPACIOS}       {}
{COMENTARIO}      {}
{COMENTARIOMULTI} {}
"{"             {return new Symbol(sym.LLAVE1, yyline, yychar, yytext());}
"}"             {return new Symbol(sym.LLAVE2, yyline, yychar, yytext());}                 
":"             {return new Symbol(sym.DOSPTS, yyline, yychar, yytext());}
"-"             {return new Symbol(sym.GUION, yyline, yychar, yytext());}
">"             {return new Symbol(sym.MAYORQUE, yyline, yychar, yytext());}
"->"            {return new Symbol(sym.FLECHA, yyline, yychar, yytext());}
";"             {return new Symbol(sym.PTYCOMA, yyline, yychar, yytext());}
"."             {return new Symbol(sym.PUNTO, yyline, yychar, yytext());}
"|"             {return new Symbol(sym.OR, yyline, yychar, yytext());}
"+"             {return new Symbol(sym.MAS, yyline, yychar, yytext());}
"*"             {return new Symbol(sym.KLEENE, yyline, yychar, yytext());}
"?"             {return new Symbol(sym.INTERROGACION, yyline, yychar, yytext());}
"CONJ"          {return new Symbol(sym.RCONJ, yyline, yychar, yytext());}
","             {return new Symbol(sym.COMA, yyline, yychar, yytext());}
"%%"            {return new Symbol(sym.PERCENT, yyline, yychar, yytext());}
{DIGITO}        {return new Symbol(sym.DIGITO, yyline, yychar, yytext());}
{LETRA}         {return new Symbol(sym.LETRA, yyline, yychar, yytext());}
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yyline, yychar, yytext());}
{CARACTER}      {return new Symbol(sym.CARACTER, yyline, yychar, yytext());}
{CHAREX}        {return new Symbol(sym.CHAREX, yyline, yychar, (yytext()).substring(1,yytext().length()-1));}
{CADENA}        {return new Symbol(sym.CADENA, yyline, yychar, (yytext()).substring(1,yytext().length()-1));}
{ESPECIALES}    {return new Symbol(sym.ESPECIAL, yyline, yychar, yytext());}
{RANGO1}        {return new Symbol(sym.RANGO1, yyline, yychar, yytext());}
{RANGO2}        {return new Symbol(sym.RANGO2, yyline, yychar, yytext());}
{RANGO3}        {return new Symbol(sym.RANGO3, yyline, yychar, yytext());}
{RANGO4}        {return new Symbol(sym.RANGO4, yyline, yychar, yytext());}


\n              {yychar=1;}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
    addError(new Estructuras.MiError(tipoError.LEXICO, "Se detectó un error lexico ("+yytext()+")", yyline, yychar));
}