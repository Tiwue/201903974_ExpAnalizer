package Analizadores;
import java_cup.runtime.Symbol; 

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
CADENA = [\"]([^\"\n]|(\\\"))*[\"]
IDENTIFICADOR=[a-z|A-Z]+["_"|a-z|0-9|A-Z]*
DIGITO= [0-9]+
LETRA = [a-zA-ZñÑ]
CARACTER = [ -}]
CHAREX = \"[^\"]\"
ESPECIALES = ("\\n"|"\\""\'"|"\\""\"")      
RANGO1 = [0-9]+"~"[0-9]+
RANGO2 = [A-Z]"~"[A-Z]
RANGO3 = [a-z]"~"[a-z]
RANGO4 = [ -}]"~"[ -}]
COMENTARIO = ("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIOMULTI = "<!""!"*([^!>]|[^!]">"|"!"[^>])*"!"*"!>"

%%

{CARACTER}       {return new Symbol(sym.CARACTER, yyline, yychar, yytext());}
{CHAREX}   {return new Symbol(sym.CHAREX, yyline, yychar, (yytext()).substring(1,yytext().length()-1));}
{CADENA}       {return new Symbol(sym.CADENA, yyline, yychar, (yytext()).substring(1,yytext().length()-1));}
{DIGITO}       {return new Symbol(sym.DIGITO, yyline, yychar, yytext());}
{LETRA}        {return new Symbol(sym.LETRA, yyline, yychar, yytext());}
{ESPECIALES}       {return new Symbol(sym.ESPECIAL, yyline, yychar, yytext());}
"{"             {return new Symbol(sym.LLAVE1, yyline, yychar, yytext());}
"}"             {return new Symbol(sym.LLAVE2, yyline, yychar, yytext());}                 
":"             {return new Symbol(sym.DOSPTS, yyline, yychar, yytext());}
"-"             {return new Symbol(sym.GUION, yyline, yychar, yytext());}
">"             {return new Symbol(sym.MAYORQUE, yyline, yychar, yytext());}
"->"            {return new Symbol(sym.FLECHA, yyline, yychar, yytext());}
";"             {return new Symbol(sym.PTYCOMA, yyline, yychar, yytext());}
"."             {return new Symbol(sym.PUNTO, yyline, yychar, yytext());}
"|"             {return new Symbol(sym.OR, yyline, yychar, yytext());}
"%%"             {return new Symbol(sym.PERCENT, yyline, yychar, yytext());}
"+"             {return new Symbol(sym.MAS, yyline, yychar, yytext());}
"*"             {return new Symbol(sym.KLEENE, yyline, yychar, yytext());}
"?"             {return new Symbol(sym.INTERROGACION, yyline, yychar, yytext());}
"CONJ"          {return new Symbol(sym.RCONJ, yyline, yychar, yytext());}
","             {return new Symbol(sym.COMA, yyline, yychar, yytext());}
{IDENTIFICADOR}  {return new Symbol(sym.IDENTIFICADOR, yyline, yychar, yytext());}
{RANGO1}         {return new Symbol(sym.RANGO1, yyline, yychar, yytext());}
{RANGO2}         {return new Symbol(sym.RANGO2, yyline, yychar, yytext());}
{RANGO3}         {return new Symbol(sym.RANGO3, yyline, yychar, yytext());}
{RANGO4}         {return new Symbol(sym.RANGO4, yyline, yychar, yytext());}
{ESPACIOS}       {}
{COMENTARIO}      {}
{COMENTARIOMULTI} {}
\n              {yychar=1;}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}