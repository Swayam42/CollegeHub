
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity MUX2to1 is
    Port ( A : in STD_LOGIC;
           B : in STD_LOGIC;
           SEL : in STD_LOGIC;
           Y : out STD_LOGIC);
end MUX2to1;

architecture Behavioral of MUX2to1 is

begin
process(A,B,SEL)
begin
 if SEL = '0' then
        Y <= A;
     else
        Y <= B;
     end if;
    end process;
   end Behavioral;


