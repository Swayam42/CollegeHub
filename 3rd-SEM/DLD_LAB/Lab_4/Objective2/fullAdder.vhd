--NAME : Swayam Swarup Jethi
--REGD NO. : 2341010085
--SEC : C1

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity fullAdder is
    Port ( A : in STD_LOGIC;
           B : in STD_LOGIC;
           C : in STD_LOGIC;
           S : out STD_LOGIC;
           Cout : out STD_LOGIC);
end fullAdder;

architecture Dataflow of fullAdder is

begin
S <= A XOR B XOR C;
Cout <= (C AND (A XOR B)) OR (A AND B);

end Dataflow;
