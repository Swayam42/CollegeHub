library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
entity four_bit_comparator is
    Port ( A : in STD_LOGIC_VECTOR (3 downto 0);
           B : in STD_LOGIC_VECTOR (3 downto 0);
           A_greater_B : out STD_LOGIC;
           A_equals_B : out STD_LOGIC;
           A_lesser_B : out STD_LOGIC);
end four_bit_comparator;
architecture Behavioral of four_bit_comparator is
begin
    process(A, B)
    begin
        if A > B then
            A_greater_B <= '1';
            A_equals_B <= '0';
            A_lesser_B <= '0';
        elsif A = B then
            A_greater_B <= '0';
            A_equals_B <= '1';
            A_lesser_B <= '0';
        else -- A < B
            A_greater_B <= '0';
            A_equals_B <= '0';
            A_lesser_B <= '1';
        end if;
    end process;
end Behavioral;
