
#export PATH=$PATH:/c/Python27/Scripts/:/c/Python27/
#find \\c\\World_of_Tanks\\res_mods -name "*.pyc"
#file /c/World_of_Tanks/res_mods/0.9.17.1/scripts/client/gui/mods/mod_pmod.pyc
import imp

import magic
#f = open('c:\\World_of_Tanks\\res_mods\\0.9.17.1\\scripts\\client\\gui\\mods\\mod_ZJ_AimBotShaytan.pyc')
#magic = f.read(4)
#print magic.encode('hex')

print magic.from_file('c:\\World_of_Tanks\\res_mods\\0.9.17.1\\scripts\\client\\gui\\mods\\mod_ZJ_AimBotShaytan.pyc', mime=True)

#module = imp.load_dynamic('tested', 'c:\\World_of_Tanks\\res_mods\\0.9.17.1\\scripts\\client\\gui\\mods\\mod_ZJ_AimBotShaytan.pyc')


