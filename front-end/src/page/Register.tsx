import { Button, Stack, TextField, Typography } from "@mui/material";
import LoginIcon from "@mui/icons-material/Login";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";
import { Link } from "react-router-dom";

export default function Register() {
  return (
    <Stack
      spacing={3}
      sx={{
        width: "100%",
      }}
    >
      <Stack spacing={1}>
        <Typography
          component="h1"
          variant="h5"
          sx={{
            fontWeight: 700,
          }}
        >
          S'inscrire
        </Typography>

        <Typography variant="body2" color="text.secondary">
          Vos coordonnées
        </Typography>
      </Stack>

      <Stack component="form" spacing={2}>
        <TextField label="Votre nom" size="small" fullWidth />

        <TextField label="Votre prénom" size="small" fullWidth />

        <TextField label="Votre email" type="email" size="small" fullWidth />

        <TextField
          label="Mot de passe"
          type="password"
          size="small"
          fullWidth
        />

        <TextField label="Ville - Code Postal" size="small" fullWidth />

        <Stack direction="row" spacing={2}>
          <TextField label="Date de naissance" size="small" fullWidth />

          <TextField label="Sexe" size="small" fullWidth />
        </Stack>

        <Stack
          direction="row"
          spacing={2}
          sx={{
            pt: 1,
          }}
        >
          <Button
            variant="outlined"
            fullWidth
            startIcon={<LoginIcon />}
            component={Link}
            to="/login"
          >
            J'ai déjà un compte
          </Button>

          <Button
            variant="contained"
            fullWidth
            startIcon={<ArrowForwardIcon />}
          >
            Poursuivre
          </Button>
        </Stack>
      </Stack>
    </Stack>
  );
}
