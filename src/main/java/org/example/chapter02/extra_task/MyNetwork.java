package org.example.chapter02.extra_task;

import java.util.HashMap;
import java.util.Map;

public class MyNetwork {
    private final Map<Integer, Member> members = new HashMap<>();
    private int nextId = 0;


    public Member addMember(String name){
        Member newMember = new Member(name);
        members.put(newMember.id, newMember);
        return newMember;
    }

    public class Member {
        private final int id;
        private final String name;

        Member(String name){
            id = nextId++;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        private void makeMessage(Member target, String message) {
            System.out.println(target.name + " received a message from " + name + ": " + message);
        }

        public void sendTo(int targetId, String message){
            MyNetwork.Member target = members.get(targetId);
            if (target != null) {
                makeMessage(target, message);
            } else {
                System.out.println("Participant with id " + targetId + " not found");
            }
        }

        public void sendEverybody(String message){
            for (Member member : members.values()) {
                if (member.id != id){
                    makeMessage(member, message);
                }
            }
        }
    }

    static void main() {
        MyNetwork nw = new MyNetwork();
        MyNetwork.Member sara = nw.addMember("Sara");
        MyNetwork.Member john = nw.addMember("John");
        MyNetwork.Member mike = nw.addMember("Mike");

        sara.sendEverybody("Hi!");
        System.out.println();
        mike.sendTo(1, "How is it going on, John?");
        System.out.println();
        john.sendTo(2, "It's ok, Mike!");
    }
}
