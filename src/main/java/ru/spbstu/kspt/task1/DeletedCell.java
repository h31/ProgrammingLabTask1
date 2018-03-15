package ru.spbstu.kspt.task1;

class DeletedCell extends Cell {
        private static DeletedCell entry = null;

        private DeletedCell() {
            super(-1, -1);
        }

        static DeletedCell getUniqueDeletedCell() {
            if (entry == null) {
                entry = new DeletedCell();
            }
            return entry;
        }
}
