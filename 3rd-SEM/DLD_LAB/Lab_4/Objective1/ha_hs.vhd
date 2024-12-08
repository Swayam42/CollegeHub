--NAME : Swayam Swarup Jethi
--REGD NO. : 2341010085
--SEC : C1
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity ha_hs is
    Port ( A : in STD_LOGIC;
           B : in STD_LOGIC;
           S : out STD_LOGIC;
           C : out STD_LOGIC;
           DIFF : out STD_LOGIC;
           BOR : out STD_LOGIC);
end ha_hs;

architecture Dataflow of ha_hs is

begin
S <= A XOR B;
C <= A AND B;
DIFF <= A XOR B;
BOR <= NOT(A) AND B;


end Dataflow;
