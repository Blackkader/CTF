**Challenge Name :** magic

### **Category :** Reverse Engineering

### **Description :**

> BOOO!!
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'se7r.zip'_

---

### Solution

Let's try to extract our zip file 

![](../.private_images/2025-02-12-10-59-30-image.png)

This time it's a real zip :D , what did we  get here hmmm

An encrypted flag and a shell script ! we can guess that the shell script takes an input and encrypts it  using a certain algorithm , let's read the script

```shell
random_seed() {
    local asdfg=$1
    RANDOM=$asdfg
}

random_choice() {
    local qwerty=$1
    echo $((RANDOM % qwerty))
}

random_seed 165

echo "se7r se7r se7r"
read -p "het ch3andek? " abc
xyz=$abc

_CRYPTIC_VORTEX_0x1=$(openssl rand -hex 16 | sha256sum | cut -d' ' -f1)
_TEMPORAL_MATRIX_SEED_=$(date +%s%N | xxd -p | fold -w256 | shuf | head -n1)
_CHAOS_FABRIC_MASTER_=$(mktemp -u).dat
_QUANTUM_ENTANGLEMENT_KEY_=$(uuidgen | sha256sum | cut -d' ' -f1)
_VOIDSTREAM_CIPHER_IV_=$(openssl rand -hex 12)
_HYPERCUBE_DECOY_ARRAY_=()



asd=""
for ((j=0; j<${#abc}; j++)); do
    r=${abc:$j:1}
    jkl=$(random_choice 5)
    mno=$(( $jkl + 49 ))
    asd+=$(printf "\\x$(printf %x $((( $(printf "%d" "'$r") + mno ) % 256)))")
done

def=$(echo "$xyz" | rev)
xyz=$(if [[ ${#xyz} -gt 0 ]]; then echo "$xyz"; fi)
xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz="$(
  for ((k=0; k<${#xyz}; k++)); do
      p=${xyz:$k:1}
      qr=$(printf "%d" "'$p")
      if ((qr >= 97 && qr <= 122)); then
          printf "\\x$(printf %x $(((qr - 97 + 13) % 26 + 97)))"
      elif ((qr >= 65 && qr <= 90)); then
          printf "\\x$(printf %x $(((qr - 65 + 13) % 26 + 65)))"
      else
          printf "%s" "$p"
      fi
  done
)"

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')



unset _CRYPTIC_VORTEX_0x1 _TEMPORAL_MATRIX_SEED_ _CHAOS_FABRIC_MASTER_ \
_QUANTUM_ENTANGLEMENT_KEY_ _VOIDSTREAM_CIPHER_IV_ _HYPERCUBE_DECOY_ARRAY_ \
_NEXUS_SHARD_ITER_ _FRAGMENT_TEMP_ _VOIDSTREAM_CIPHER_CHAIN_ _QUANTUM_CYCLE_ \
_CHAIN_INPUT_BUFFER_ _ENCRYPTED_CHUNK_ _ENTROPIC_GRID_MATRIX_ _CELL_DECRYPT_INDEX_ \
_QUANTUM_CELL_ _CELL_HASH_ _ENCRYPTED_CELL_ _TEMPORAL_ECHO_BUFFER_ _ECHO_ITER_ \
_ECHO_HASH_CHAIN_ _ECHO_ENCRYPTED_ _ABYSSAL_KEYSTREAM_ _KEYSTREAM_SEG_ _SEGMENT_DIGEST_ \
_TRANSFORMED_SEGMENT_ _ENCRYPTED_SEGMENT_ _QUANTUM_ENTANGLEMENT_MATRIX_ _NODE_CRYPT_INDEX_ \
_ENTANGLEMENT_NODE_ _NODE_HASH_ _NODE_CIPHER_ _STELLAR_OBFUSCATION_CYCLE_ _CYCLIC_KEY_ \
_CYCLIC_IV_ _CYCLIC_PAYLOAD_ _CYCLIC_CIPHER_


xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

zyx=$(for ((k=0; k<20; k++)); do printf "%s" $(random_choice 26 | awk '{printf("%c", $1 + 97)}'); done | head -c 1)

ls $_CHAOS_FABRIC_MASTER_ $_ENTROPIC_GRID_MATRIX_ $_TEMPORAL_ECHO_BUFFER_ \
$_ABYSSAL_KEYSTREAM_ $_QUANTUM_ENTANGLEMENT_MATRIX_ 2>/dev/null


xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')


ehryf="GRATZ THIS IS THE FLAG"

xyz="$(
  for ((k=0; k<${#xyz}; k++)); do
      p=${xyz:$k:1}
      qr=$(printf "%d" "'$p")
      if ((qr >= 97 && qr <= 122)); then
          printf "\\x$(printf %x $(((qr - 97 + 20) % 26 + 97)))"
      elif ((qr >= 65 && qr <= 90)); then
          printf "\\x$(printf %x $(((qr - 65 + 20) % 26 + 65)))"
      else
          printf "%s" "$p"
      fi
  done
)"

xyz+=$(echo "$xyz" | head -c 0)

_STELLAR_OBFUSCATION_CYCLE_=0
while [ $_STELLAR_OBFUSCATION_CYCLE_ -lt 24 ]; do
    _CYCLIC_KEY_=$(uuidgen | sha256sum | cut -d' ' -f1)
    _CYCLIC_IV_=$(openssl rand -hex 16)
    _CYCLIC_PAYLOAD_=$(openssl rand -hex 32 | base64 -w0)
    _CYCLIC_CIPHER_=$(openssl enc -aes-256-gcm -K $_CYCLIC_KEY_ -iv $_CYCLIC_IV_ \
    -in <(echo $_CYCLIC_PAYLOAD_) 2>/dev/null | base64 -w0)
    _HYPERCUBE_DECOY_ARRAY_+=($_CYCLIC_CIPHER_)
    _STELLAR_OBFUSCATION_CYCLE_=$((_STELLAR_OBFUSCATION_CYCLE_ + 1))
done

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

lmn=""
for ((k=0; k<12; k++)); do
    lmn+=$(printf "\\x$(printf %x $((32 + $(random_choice 95)))))")
done

xyz=$(echo "$xyz" | tr "$xyz" "$xyz")

_QUANTUM_ENTANGLEMENT_MATRIX_=$(mktemp -u).qem
dd if=/dev/urandom of=$_QUANTUM_ENTANGLEMENT_MATRIX_ bs=128 count=16 status=none
split -b 32 $_QUANTUM_ENTANGLEMENT_MATRIX_ ${_QUANTUM_ENTANGLEMENT_MATRIX_}.node 2>/dev/null


uvw=""
for ((k=0; k<${#xyz}; k++)); do
    p=${xyz:$k:1}
    qr=$(printf "%d" "'$p")
    uvw+=$(printf "\\x$(printf %x $(((qr - 32 + 10) % 95 + 32)))")
done

xyz=$(echo "$xyz" | rev | tr -cd "$xyz")

dd if=/dev/urandom of=$_CHAOS_FABRIC_MASTER_ bs=512 count=32 status=none
openssl enc -aes-256-ctr -K $(echo $_CRYPTIC_VORTEX_0x1 | cut -c1-64) \
-iv $(openssl rand -hex 16) -in $_CHAOS_FABRIC_MASTER_ -out /dev/null 2>/dev/null



xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')
rst=""

for ((k=0; k<10; k++)); do
    rst+=$(printf "%s" "$(random_choice 32 | awk '{printf("%c", $1+33)}')")
done

xyz=( $(echo "$xyz" | sed 's/./& /g') )

_NEXUS_SHARD_ITER_=0
while [ $_NEXUS_SHARD_ITER_ -lt 16 ]; do
    _FRAGMENT_TEMP_=${_CHAOS_FABRIC_MASTER_}.frag.$_NEXUS_SHARD_ITER_
    dd if=$_CHAOS_FABRIC_MASTER_ of=$_FRAGMENT_TEMP_ bs=16 count=1 skip=$_NEXUS_SHARD_ITER_ status=none
    _HYPERCUBE_DECOY_ARRAY_+=($(openssl dgst -sha3-512 -binary $_FRAGMENT_TEMP_ | base64 -w0))
    ls $_FRAGMENT_TEMP_ 2>/dev/null
    _NEXUS_SHARD_ITER_=$((_NEXUS_SHARD_ITER_ + 1))
done

xyz=$(for p in "${xyz[@]}"; do printf "\\x$(printf %x $((( $(printf "%d" "'$p") - 5) % 256)))"; done)
xyz=$(echo "$xyz" | rev | rev)

zxcv=()
for ((k=0; k<${#xyz}; k++)); do
    l=${xyz:$k:1}
    zxcv+=( $(printf "%08d" "$(echo "obase=2; ibase=10; $(printf "%d" "'$l")" | bc)") )
done

qwert=()
for l in "${zxcv[@]}"; do
    qwert+=( $(printf "%08d" "$(echo "obase=2; ibase=10; $((2#$l ^ 8))" | bc)") )
done

for i in {0..15}; do
    dd if=/dev/urandom bs=1M count=64 | openssl enc -rc2-64-cbc -K $(echo $VOID_CONSTANT | sha256sum | cut -d' ' -f1) -iv $(dd if=/dev/urandom bs=8 count=1 status=none | hexdump -v -e '/1 "%02X"') > /dev/null
    shred -u "${NOCTURNE_CIPHER}.$i" > /dev/null 2>&1
done


xyz=$(IFS=; echo "${qwert[*]}")

echo "$xyz"
echo "magic is done ."
```

What is all of this , this looks scary and too complicated , time to give up and rest a bit ....

NOO ! read the description , it says **BOOO!!** the script is supposed to be scary not hard ! let's try to run it and give it this input **BOOO**

```
d: failed to open '': No such file or directory
dd: failed to open '': No such file or directory
.frag.0: No such file or directory
80DB5B95757F0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.0, r)
80DB5B95757F0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.1: No such file or directory
807B8BF6727A0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.1, r)
807B8BF6727A0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.2: No such file or directory
800BEC346D750000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.2, r)
800BEC346D750000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.3: No such file or directory
80DB0566E67C0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.3, r)
80DB0566E67C0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.4: No such file or directory
80CB3FD7AF740000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.4, r)
80CB3FD7AF740000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.5: No such file or directory
80FB8F3542700000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.5, r)
80FB8F3542700000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.6: No such file or directory
805B528B317E0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.6, r)
805B528B317E0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.7: No such file or directory
803BD15B69730000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.7, r)
803BD15B69730000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.8: No such file or directory
80EB69C753780000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.8, r)
80EB69C753780000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.9: No such file or directory
805B8F90EF7E0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.9, r)
805B8F90EF7E0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.10: No such file or directory
80BBB438F27C0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.10, r)
80BBB438F27C0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.11: No such file or directory
80CB508FB57D0000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.11, r)
80CB508FB57D0000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.12: No such file or directory
805BDBF2A0750000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.12, r)
805BDBF2A0750000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.13: No such file or directory
80BBE49FDA760000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.13, r)
80BBE49FDA760000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.14: No such file or directory
803BB28EAD780000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.14, r)
803BB28EAD780000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
dd: failed to open '': No such file or directory
.frag.15: No such file or directory
80DBE4730D770000:error:80000002:system library:file_ctrl:No such file or directory:crypto/bio/bss_file.c:297:calling fopen(.frag.15, r)
80DBE4730D770000:error:10080002:BIO routines:file_ctrl:system lib:crypto/bio/bss_file.c:300:
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
801B223DA9730000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
80EBE0D0E4740000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
80CB48D314750000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
80CBAC9E3D740000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
803B49B225770000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
802B657A32700000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
801B09B263760000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
800B60384E790000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
806B19B953730000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
803B158A53700000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
80DBD795277D0000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
807BAAB99B780000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
804B78C19F7B0000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
809B21D61B7C0000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
80EB76C1677C0000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
hex string is too long, ignoring excess
Error setting cipher RC2-64-CBC
800B09A587760000:error:0308010C:digital envelope routines:inner_evp_generic_fetch:unsupported:crypto/evp/evp_fetch.c:355:Global default library context, Algorithm (RC2-64-CBC : 0), Properties ()
01011001010110010101100101001100
magic is done .
```

It is trying to open up files from my system and doing some crypto  !! is the author trying to hack me or something ? i don't think so :/ , but what is interesting here are the last two lines ! 

```
01011001010110010101100101001100
magic is done .
```

let's try with another input , this time i'll make it one character "A"

and again we inspect the last two lines :

```
01001011
magic is done .
```

and now with "AA"

```
0100101101001011
magic is done .
```

we can guess now that each encrypted character is an 8 length string !

Time to dig into the script ! , but this time we will start from the end (where the encrypted input is being printed)

```shell
echo "$xyz"
echo "magic is done ."
```

so the variable we are interested in is $$xyz$

all the other things are just decoys !! , so let's remove all unnecessary lines 

```shell
random_seed() {
    local asdfg=$1
    RANDOM=$asdfg
}

random_choice() {
    local qwerty=$1
    echo $((RANDOM % qwerty))
}

random_seed 165

echo "se7r se7r se7r"
read -p "het ch3andek? " abc
xyz=$abc

xyz=$(if [[ ${#xyz} -gt 0 ]]; then echo "$xyz"; fi)
xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz="$(
  for ((k=0; k<${#xyz}; k++)); do
      p=${xyz:$k:1}
      qr=$(printf "%d" "'$p")
      if ((qr >= 97 && qr <= 122)); then
          printf "\\x$(printf %x $(((qr - 97 + 13) % 26 + 97)))"
      elif ((qr >= 65 && qr <= 90)); then
          printf "\\x$(printf %x $(((qr - 65 + 13) % 26 + 65)))"
      else
          printf "%s" "$p"
      fi
  done
)"

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz="$(
  for ((k=0; k<${#xyz}; k++)); do
      p=${xyz:$k:1}
      qr=$(printf "%d" "'$p")
      if ((qr >= 97 && qr <= 122)); then
          printf "\\x$(printf %x $(((qr - 97 + 20) % 26 + 97)))"
      elif ((qr >= 65 && qr <= 90)); then
          printf "\\x$(printf %x $(((qr - 65 + 20) % 26 + 65)))"
      else
          printf "%s" "$p"
      fi
  done
)"

xyz+=$(echo "$xyz" | head -c 0)

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz=$(echo "$xyz" | tr "$xyz" "$xyz")


xyz=$(echo "$xyz" | rev | tr -cd "$xyz")

xyz=$(echo "$xyz" | awk '{for (h=1; h<=length; h++) printf("%s", substr($0, h, 1));}')

xyz=( $(echo "$xyz" | sed 's/./& /g') )

xyz=$(for p in "${xyz[@]}"; do printf "\\x$(printf %x $((( $(printf "%d" "'$p") - 5) % 256)))"; done)
xyz=$(echo "$xyz" | rev | rev)

zxcv=()
for ((k=0; k<${#xyz}; k++)); do
    l=${xyz:$k:1}
    zxcv+=( $(printf "%08d" "$(echo "obase=2; ibase=10; $(printf "%d" "'$l")" | bc)") )
done

qwert=()
for l in "${zxcv[@]}"; do
    qwert+=( $(printf "%08d" "$(echo "obase=2; ibase=10; $((2#$l ^ 8))" | bc)") )
done

xyz=$(IFS=; echo "${qwert[*]}")

echo "$xyz"
echo "magic is done ."
```

Now we have everything related to $$xyz$

If you are like me , someone who hates shell , we can try to convert this to python !!! , debug each line , or use ai

By doing that we can confirm that we have even more decoys !

```python
import random

def random_seed(asdfg):
    random.seed(asdfg)

def random_choice(qwerty):
    return random.randint(0, qwerty - 1)

random_seed(165)

print("se7r se7r se7r")
xyz = input("het ch3andek? ")

xyz = xyz if len(xyz) > 0 else ""
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = "".join([chr((ord(p) - 97 + 13) % 26 + 97) if 97 <= ord(p) <= 122 else chr((ord(p) - 65 + 13) % 26 + 65) if 65 <= ord(p) <= 90 else p for p in xyz])
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = "".join([chr((ord(p) - 97 + 20) % 26 + 97) if 97 <= ord(p) <= 122 else chr((ord(p) - 65 + 20) % 26 + 65) if 65 <= ord(p) <= 90 else p for p in xyz])
xyz += xyz[:0]
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = xyz.translate(str.maketrans(xyz, xyz))
xyz = xyz[::-1].translate(str.maketrans('', '', xyz))
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = [char for char in xyz]
xyz = "".join([chr((ord(p) - 5) % 256) for p in xyz])
xyz = xyz[::-1]
zxcv = [format(ord(l), '08b') for l in xyz]
qwert = [format(int(b, 2) ^ 8, '08b') for b in zxcv]
xyz = "".join(qwert)

print(xyz)
print("magic is done .")
```

Those lines are :

```python
```python
import random

def random_seed(asdfg):
    random.seed(asdfg)

def random_choice(qwerty):
    return random.randint(0, qwerty - 1)

random_seed(165)
```

xyz = xyz if len(xyz) > 0 else ""
xyz = "".join([xyz[h] for h in range(len(xyz))])
xyz = [char for char in xyz]
xyz += xyz[:0]
xyz = xyz.translate(str.maketrans(xyz, xyz))
xyz = xyz[::-1].translate(str.maketrans('', '', xyz))

```
Removing them will even get us a shorted code : 

```python
print("se7r se7r se7r")
xyz = input("het ch3andek? ")
xyz = "".join([chr((ord(p) - 97 + 13) % 26 + 97) if 97 <= ord(p) <= 122 else chr((ord(p) - 65 + 13) % 26 + 65) if 65 <= ord(p) <= 90 else p for p in xyz])
xyz = "".join([chr((ord(p) - 97 + 20) % 26 + 97) if 97 <= ord(p) <= 122 else chr((ord(p) - 65 + 20) % 26 + 65) if 65 <= ord(p) <= 90 else p for p in xyz])
xyz = "".join([chr((ord(p) - 5) % 256) for p in xyz[::-1]])
zxcv = [format(ord(l), '08b') for l in xyz]
qwert = [format(int(b, 2) ^ 8, '08b') for b in zxcv]
xyz = "".join(qwert)
print(xyz)
print("magic is done .")
```

ouffff , from 170 lines to 10 lines !

NOW TIME TO REVERSEEE ! 

Let's see what does each line do ! 

```python
#ROT13:
xyz = "".join([chr((ord(p) - 97 + 13) % 26 + 97) if 97 <= ord(p) <= 122 else chr((ord(p) - 65 + 13) % 26 + 65) if 65 <= ord(p) <= 90 else p for p in xyz])
#ROT20:
xyz = "".join([chr((ord(p) - 97 + 20) % 26 + 97) if 97 <= ord(p) <= 122 else chr((ord(p) - 65 + 20) % 26 + 65) if 65 <= ord(p) <= 90 else p for p in xyz])
#Reversing the string then shifting by -5 for each character in the ascii table :
xyz = "".join([chr((ord(p) - 5) % 256) for p in xyz[::-1]])
#Converting each character to binary represented in 8 bits 
zxcv = [format(ord(l), '08b') for l in xyz]
#Each character is XORED with 8 and then the result is converted again to binary representation
qwert = [format(int(b, 2) ^ 8, '08b') for b in zxcv]
#The resulting list is joined into a single  string 
xyz = "".join(qwert)
```

Time to get that encryptedflag and run it through our solver !

```python
import string

print("Decryptingggg .")

v2="0111000000110010011000100101010101100010010100100110100101111101011010110010011001010010011111010010011101010111010100100110111101111000011110010101001001111101001001000110001001010100011111100100101000110100001001000100011001000000"
l=[v2[i:i+8]for i in range(0,len(v2),8)]
l2 = [f"{(int(e, 2) ^ int('00001000', 2)):08b}" for e in l]
v2="".join(l2)
l3=[chr(int(v2[i:i+8],2))for i in range(0,len(v2),8)]
v2="".join(l3)

v2 = v2[::-1]


v2 = ''.join([chr((ord(v4) + 5) % 256) for v4 in v2])


v2 = ''.join([chr(((ord(v4) - 97 - 20) % 26) + 97) if 'a' <= v4 <= 'z' else
              (chr(((ord(v4) - 65 - 20) % 26) + 65) if 'A' <= v4 <= 'Z' else v4) for v4 in v2])

v2 = ''.join([chr(((ord(v4) - 97 - 13) % 26) + 97) if 'a' <= v4 <= 'z' else
              (chr(((ord(v4) - 65 - 13) % 26) + 65) if 'A' <= v4 <= 'Z' else v4) for v4 in v2])


print("flag  :", v2)
```

And there u go : 

```
FL1TZ{th1s_one_w4s_3asy_huh?}
```

---
