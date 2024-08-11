package Drvo;

public class SLLTreeTest {

    public static void main(String[] args) {

        Tree.Node<String> a, b, c, d;

        //a ke se prvite deca na roditelite - Windows, Users, Program files
        //b ke se deca na decata
        //t. root ke se roditelite

        SLLTree<String> t = new SLLTree<String>();

        t.makeRoot("C:"); //направи елемент c da bide root
        //vo SLLTree vnesuvame fakticki

        a = t.addChild(t.root, "Program files");
        b = t.addChild(a, "CodeBlocks"); //dete na a, toa ke bide CodeBlocks
        c = t.addChild(b, "codeblocks.dll"); //codeblocks.dll i codeblocks.exe se deca na b
        c = t.addChild(b, "codeblocks.exe");
        b = t.addChild(a, "Nodepad++");
        c = t.addChild(b, "langs.xml");
        d = c;
        c = t.addChild(b, "readme.txt");
        c = t.addChild(b, "notepad++.exe");
        a = t.addChild(t.root, "Users");
        b = t.addChild(a, "Darko"); //dete na Users
        c = t.addChild(b, "Desktop");
        c = t.addChild(b, "Downloads");
        c = t.addChild(b, "My Documents");
        c = t.addChild(b, "My Pictures");
        b = t.addChild(a, "Public");
        a = t.addChild(t.root, "Windows");
        b = t.addChild(a, "Media"); //dete na Windows

        //odi rekurzivno zatoa naopaku se napisani

        t.printTree();

        t.remove(d);
        t.printTree();

        System.out.println("The maximum number of children is "
                + t.countMaxChildren());

    }

}
