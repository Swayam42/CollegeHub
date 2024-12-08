--NAME : Swayam Swarup Jethi
--REGD NO. : 2341010085
--SEC : C1

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

 entity two_bit_BPA is
 Port ( A0 : in STD_LOGIC;
 B0 : in STD_LOGIC;
 S0 : out STD_LOGIC;
 A1 : in STD_LOGIC;
 B1 : in STD_LOGIC;
 S1 : out STD_LOGIC;
 Cout : out STD_LOGIC);
 end two_bit_BPA;
 architecture Dataflow of two_bit_BPA is
 signal C0_internal : STD_LOGIC;
 begin
 S0 <= A0 XOR B0;
 C0_internal <= A0 AND B0;
 S1 <= A1 XOR B1 XOR C0_internal;
 Cout <= (A1 AND B1) OR (B1 AND C0_internal) OR (A1 and C0_internal);
 end Dataflow;
