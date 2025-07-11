package design.ATMMachine;

class ATM {
    int[] notes;
    public ATM() {
        this.notes = new int[5];
    }
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < notes.length; i++) {
            this.notes[i] += banknotesCount[i];
        }
    }
    public int[] withdraw(int amount) {
        int[] withdrawn = new int[5];

        int i = 4;
        while(amount != 0){
            if(amount >= 500 && notes[4] > 0 && withdrawn[i] < notes[4]){
                withdrawn[4]++;
                amount -= 500;
            }
            else if(amount >= 200 && notes[3] > 0 && withdrawn[3] < notes[3]){
                withdrawn[3]++;
                amount -= 200;
            }
            else if(amount >= 100 && notes[2] > 0 && withdrawn[2] < notes[2]){
                withdrawn[2]++;
                amount -= 100;
            }
            else if(amount >= 50 && notes[1] > 0 && withdrawn[1] < notes[1]){
                withdrawn[1]++;
                amount -= 50;
            }
            else if(amount >= 20 && notes[0] > 0 && withdrawn[0] < notes[0]){
                withdrawn[1]++;
                amount -= 20;
            }
        }

        return withdrawn;
    }
}
