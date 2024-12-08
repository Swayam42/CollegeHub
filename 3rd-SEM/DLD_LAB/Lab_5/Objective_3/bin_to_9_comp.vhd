--NAME : Swayam Swarup Jethi
--REGD NO. : 2341010085
--SEC : C1

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Binary-to-Nine's Complement Converter
entity bin_to_9_comp is
    Port ( 
        BCD : in STD_LOGIC_VECTOR (3 downto 0); -- 4-bit BCD input
        NINE_COMP : out STD_LOGIC_VECTOR (3 downto 0) -- 4-bit nine's complement output
    );
end bin_to_9_comp;

architecture Dataflow of bin_to_9_comp is
begin
    NINE_COMP(3) <= NOT(BCD(3)) AND NOT(BCD(2)) AND NOT(BCD(1)); -- MSB
    NINE_COMP(2) <= BCD(2) XOR BCD(1); -- Second MSB
    NINE_COMP(1) <= BCD(1); -- Pass-through
    NINE_COMP(0) <= NOT(BCD(0)); -- Invert LSB
end Dataflow;

