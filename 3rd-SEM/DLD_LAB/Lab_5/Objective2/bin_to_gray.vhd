--NAME : Swayam Swarup Jethi
--REGD NO. : 2341010085
--SEC : C1
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity bin_to_gray is
    Port ( B : in STD_LOGIC_VECTOR (3 downto 0);
           G : out STD_LOGIC_VECTOR (3 downto 0));
end bin_to_gray;

architecture Dataflow of bin_to_gray is

begin
    G(3) <= B(3);
    G(2) <= B(3) XOR B(2);
    G(1) <= B(2) XOR B(1);
    G(0) <= B(1) XOR B(0);

end Dataflow;
