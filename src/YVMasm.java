
public class YVMasm extends YVM {

	public YVMasm(String filename) {
		super(filename);
	}

	@Override
	public void entete() {
		result += "; entete\n";
		result += ".MODEL SMALL\n";
		result += "\t.586\n";
		result += "\n";
		result += ".CODE\n";
		result += "debut:\n";
		result += " \tSTARTUPCODE\n";
		result += "\n";
	}

	@Override
	public void queue() {
		result += "; queue\n";
		result += "\tnop\n";
		result += "\texitcode\n";
		result += "\tEND debut\n";
	}

	@Override
	public void iadd() {
		result += "; iadd\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tadd ax, bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void isub() {
		result += "; isub\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tsub ax, bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void imul() {
		result += "; imul\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\timul bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void idiv() {
		result += "; idiv\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcwd\n";
		result += "\tidiv bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void inot() {
		result += "; inot\n";
		result += "\tpop ax\n";
		result += "\tnot ax\n";
		result += "\tpush ax\n";
		/*result += "\tpop ax\n";
		result += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";*/
		result += "\n";
	}

	@Override
	public void ineg() {
		result += "; ineg\n";
		result += "\tpop ax\n";
		result += "\tneg ax\n";
		result += "\tpush ax\n";
		/*result += "\tpop bx\n";
		result += "\tpush -1\n";
		result += "\timul bx\n";
		result += "\tpush ax\n";*/
		result += "\n";
	}

	@Override
	public void ior() {
		result += "; ior\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tor ax, bx\n";
		result += "\tpush ax\n";
		/*result += "\tpop ax\n";
		result += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+7\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";*/
		result += "\n";

	}

	@Override
	public void iand() {
		result += "; iand\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tand ax, bx\n";
		result += "\tpush ax\n";
		/*result += "\tpop ax\n";
		result += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\tjmp $+7\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";*/
		result += "\n";
	}

	@Override
	public void iinf() {
		result += "; iinf\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjge $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\n";
	}

	@Override
	public void isup() {
		result += "; isup\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjle $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\n";
	}

	@Override
	public void iinfegal() {
		result += "; iinfegal\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjg $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\n";
	}

	@Override
	public void isupegal() {
		result += "; isupegal\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjl $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\n";
	}

	@Override
	public void iegal() {
		result += "; iegal\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjne $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\n";
	}

	@Override
	public void idiff() {
		result += "; idiff\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tje $+3\n";
		result += "\tpush "+Integer.toString(TRUE)+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+Integer.toString(FALSE)+"\n";
		result += "\n";
	}

	@Override
	public void iload(int offset) {
		result += "; iload "+offset+"\n";
		result += "\tpush word ptr [bp"+offset+"]\n";
		result += "\n";
	}

	@Override
	public void istore(int offset) {
		result += "; istore "+offset+"\n";
		result += "\tpop ax\n";
		result += "\tmov word ptr [bp"+offset+"], ax\n";
		result += "\n";
	}

	@Override
	public void iconst(int valeur) {
		result += "; iconst "+valeur+"\n";
		result += "\tpush "+valeur+"\n";
		result += "\n";
	}

	@Override
	public void ifeq(String label) {
		result += "; ifeq\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, 0\n";
		result += "\tje "+label+"\n";
		result += "\n";

	}

	@Override
	public void iffaux(String label) {
		result += "; iffaux\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		result += "\tje "+label+"\n";
		result += "\n";
	}

	@Override
	public void jump(String label) {
		result += "; jump "+label+"\n";
		result += "\tjmp "+label+"\n";
		result += "\n";
	}

	@Override
	public void ouvrePrinc(int slot) {
		result += "; ouvrePrinc "+slot+"\n";
		result += "\tmov bp, sp\n";
		result += "\tsub sp, "+slot+"\n";
		result += "\n";
	}

}

