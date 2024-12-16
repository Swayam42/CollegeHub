library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity decoder_3to8_NAND is
    Port ( A : in STD_LOGIC_VECTOR (2 downto 0);
           EN : in STD_LOGIC;
           Y : out STD_LOGIC_VECTOR (7 downto 0));
end decoder_3to8_NAND;

architecture Behavioral of decoder_3to8_NAND is

begin
 process(A,EN)
 begin
    if EN ='0' then
        Y(0) <= not(not A(2)and not A(1) and not A(0));
         Y(1) <= not(not A(2)and not A(1) and A(0));
          Y(2) <= not(not A(2)and A(1) and not A(0));
           Y(3) <= not(not A(2)and A(1) and A(0));
            Y(4) <= not(A(2)and not A(1) and not A(0));
             Y(5) <= not(A(2)and not A(1) and A(0));
              Y(6) <= not(A(2)and A(1) and not A(0));
               Y(7) <= not(A(2)and A(1) and not A(0));
      else
        Y <= (others => '1');        
      end if;
     end process;

end Behavioral;
